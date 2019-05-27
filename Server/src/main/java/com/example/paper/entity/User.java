package com.example.paper.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "tbl_user")
public class User {
    /**
     * 用户名
     */
    @Id
    @Column
    private String username = "";

    /**
     * 密码
     */
    @Column
    private String password = "";

    /**
     * 收藏的论文的id列表，用逗号分隔
     */
    @Column
    private String paperIds = "";

    @Transient
    private ArrayList<Integer> paperIdList = new ArrayList<>();

    /**
     * 收藏的期刊的id列表，用逗号分隔
     */
    @Column
    private String periodicalIds = "";

    @Transient
    private ArrayList<Integer> periodicalIdList = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaperIds() {
        return paperIds;
    }

    public void setPaperIds(String paperIds) {
        this.paperIds = paperIds;
    }

    public ArrayList<Integer> getPaperIdList() {
        stringToPaperIdList();
        return paperIdList;
    }

    public void setPaperIdList(ArrayList<Integer> paperIdList) {
        this.paperIdList = paperIdList;
    }

    public boolean addPaper(int paperId){
        stringToPaperIdList();
        if(paperIdList.contains(paperId)){
            return false;
        }
        paperIdList.add(paperId);
        paperIds = paperIdListToString();
        return true;
    }

    public boolean deletePaper(int paperId){
        stringToPaperIdList();
        if(paperIdList.contains(paperId)) {
            paperIdList.remove((Integer) paperId);
            paperIds = paperIdListToString();
            return true;
        }else {
            return false;
        }
    }

    private void stringToPaperIdList(){
        if(!(paperIds.equals(""))){
            String[] temp = paperIds.split(",");
            for (int i = 0; i < temp.length; i++) {
                paperIdList.add(Integer.valueOf(temp[i]));
            }
        }
    }

    private String paperIdListToString(){
        if(paperIdList.size()>0){
            StringBuilder res = new StringBuilder();
            for(int i=0;i<paperIdList.size();i++){
                res.append(paperIdList.get(i)).append(",");
            }
            return new String(res).substring(0, res.length() - 1);
        }else {
            return "";
        }
    }

    public String getPeriodicalIds() {
        return periodicalIds;
    }

    public void setPeriodicalIds(String periodicalIds) {
        this.periodicalIds = periodicalIds;
    }

    public ArrayList<Integer> getPeriodicalIdList() {
        stringToPeriodicalIdList();
        return periodicalIdList;
    }

    public void setPeriodicalIdList(ArrayList<Integer> periodicalIdList) {
        this.periodicalIdList = periodicalIdList;
    }

    public boolean addPeriodical(int periodicalId){
        stringToPeriodicalIdList();
        if(periodicalIdList.contains(periodicalId)){
            return false;
        }
        periodicalIdList.add(periodicalId);
        periodicalIds = periodicalIdListToString();
        return true;
    }

    public boolean deletePeriodical(int periodicalId){
        stringToPeriodicalIdList();
        if(periodicalIdList.contains(periodicalId)) {
            periodicalIdList.remove((Integer) periodicalId);
            periodicalIds = periodicalIdListToString();
            return true;
        }else {
            return false;
        }
    }

    private void stringToPeriodicalIdList(){
        if(!(periodicalIds.equals(""))){
            String[] temp = periodicalIds.split(",");
            for (int i = 0; i < temp.length; i++) {
                periodicalIdList.add(Integer.valueOf(temp[i]));
            }
        }
    }

    private String periodicalIdListToString(){
        if(periodicalIdList.size()>0){
            StringBuilder res = new StringBuilder();
            for(int i=0;i<periodicalIdList.size();i++){
                res.append(periodicalIdList.get(i)).append(",");
            }
            return new String(res).substring(0, res.length() - 1);
        }else {
            return "";
        }
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
