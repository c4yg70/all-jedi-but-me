package com.example.paper.service;

import com.example.paper.bl.PeriodicalService;
import com.example.paper.dao.PeriodicalRepo;
import com.example.paper.dao.UserRepo;
import com.example.paper.entity.Periodical;
import com.example.paper.entity.User;
import com.example.paper.response.BasicResponse;
import com.example.paper.response.PeriodicalVO;
import com.example.paper.util.CSVUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.*;

import java.io.File;
import java.util.*;
import java.util.logging.Logger;

@Service
public class PeriodicalServiceImpl implements PeriodicalService {
    @Autowired
    private PeriodicalRepo periodicalRepo;
    @Autowired
    private UserRepo userRepo;

    private static final int NEIGHBORHOOD_NUM = 2;
    private static final int RECOMMENDER_NUM = 3;

    @Override
    public List<String> getAllCategories(){
        List<Periodical> periodicalList = periodicalRepo.findAll();
        List<String> categories = new ArrayList<>();
        for (Periodical aPeriodicalList : periodicalList) {
            String category = aPeriodicalList.getCategory();
            if (!categories.contains(category)) {
                categories.add(category);
            }
        }
        return categories;
    }

    @Override
    public List<PeriodicalVO> getPeriodicalsByCategory(String category){
        List<Periodical> periodicalList = periodicalRepo.findPeriodicalByCategory(category);
        List<PeriodicalVO> periodicalVOS = new ArrayList<>();
        for (Periodical aPeriodicalList : periodicalList) {
            periodicalVOS.add(new PeriodicalVO(aPeriodicalList));
        }
        return periodicalVOS;
    }

    @Override
    public List<PeriodicalVO> getPeriodicalsByUserName(String username){
        Optional<User> userOptional = userRepo.findById(username);
        if(userOptional.isPresent()) {
            List<PeriodicalVO> periodicalVOS = new ArrayList<>();
            User user = userOptional.get();
            ArrayList<Integer> periodicalIdList = user.getPeriodicalIdList();
            for (Integer aPeriodicalIdList : periodicalIdList) {
                Optional<Periodical> periodicalOptional = periodicalRepo.findById(aPeriodicalIdList);
                if (periodicalOptional.isPresent()) {
                    Periodical periodical = periodicalOptional.get();
                    periodicalVOS.add(new PeriodicalVO(periodical));
                }
            }
            return periodicalVOS;
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public BasicResponse addPeriodicalToUser(int periodicalId, String username){
        Optional<User> userOptional = userRepo.findById(username);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.addPeriodical(periodicalId)){
                userRepo.save(user);
                return new BasicResponse(true,"");
            }else {
                return new BasicResponse(false,"该期刊已被收藏！");
            }
        }else {
            return new BasicResponse(false,"该用户名不存在！");
        }
    }

    @Override
    public BasicResponse deletePeriodicalToUser(int periodicalId, String username){
        Optional<User> userOptional = userRepo.findById(username);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.deletePeriodical(periodicalId)){
                userRepo.save(user);
                return new BasicResponse(true,"");
            }else {
                return new BasicResponse(false,"该期刊未被收藏！");
            }
        }else {
            return new BasicResponse(false,"该用户名不存在！");
        }
    }

    @Override
    public int getPeriodicalCount(String username){
        Optional<User> userOptional = userRepo.findById(username);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPeriodicalIdList().size();
        }else {
            return 0;
        }
    }

    @Override
    public List<PeriodicalVO> recommend(String username){
        List<PeriodicalVO> periodicalVOS = new ArrayList<>();
        //csv文件生成
        LinkedHashMap<String,String> map = new LinkedHashMap();
        map.put("1", "用户ID");
        map.put("2", "期刊ID");
        map.put("3", "是否订阅");
        List exportData = new ArrayList<Map>();
        LinkedHashMap<String,String> row1;
        List<User> userList = userRepo.findAll();
        List<String> userIds = new ArrayList<>();
        for (User anUserList : userList) {
            userIds.add(anUserList.getUsername());
        }
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            if(!user.getPeriodicalIds().equals("")) {
                String[] periodicalIds = user.getPeriodicalIds().split(",");
                for (String periodicalId : periodicalIds) {
                    row1 = new LinkedHashMap();
                    row1.put("1", i + "");
                    row1.put("2", periodicalId + "");
                    row1.put("3", "5.0");
                    exportData.add(row1);
                }
            }

        }
        String path = "/root/data/";
        String fileName ="CSV文件生成";
        File file = CSVUtils.createCSVFile(exportData, map, path, fileName);

        //基于用户的协同过滤算法
        try {
            DataModel model = new FileDataModel(file);
            UserSimilarity user = new EuclideanDistanceSimilarity(model);
            NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
            Recommender r = new GenericUserBasedRecommender(model, neighbor, user);
            LongPrimitiveIterator iter = model.getUserIDs();
            while (iter.hasNext()) {
                long uid = iter.next();
                List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);
                if((int)uid == userIds.indexOf(username)){
                    for (RecommendedItem ritem : list) {
                        int itemId = (int) ritem.getItemID();
                        Optional<Periodical> periodicalOptional = periodicalRepo.findById(itemId);
                        if(periodicalOptional.isPresent()) {
                            Periodical periodical = periodicalOptional.get();
                            periodicalVOS.add(new PeriodicalVO(periodical));
                        }
                    }
                }
            }
            return periodicalVOS;
        }catch (Exception e){
            return Collections.emptyList();
        }
    }
}
