package com.example.paper.runner;

import com.example.paper.dao.PaperRepo;
import com.example.paper.dao.StatisticsRepo;
import com.example.paper.entity.Paper;
import com.example.paper.entity.Statistics;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Component
public class PaperInit implements ApplicationRunner {
    @Autowired
    private PaperRepo paperRepo;
    @Autowired
    private StatisticsRepo statisticsRepo;

    @Override
    public void run(ApplicationArguments args) {
        if(paperRepo.count() == 0) {
            String separator = System.getProperty("file.separator");
//            String path = "src" + separator
//                    + "main" + separator
//                    + "java" + separator
//                    + "com" + separator
//                    + "example" + separator
//                    + "paper" + separator
//                    + "new_paper_info.xlsx";
//            String path = "/root/new_paper_info.xlsx";
            String path = separator + "root"
                    + separator + "paper"
                    + separator + "data"
                    + separator + "new_paper_info.xlsx";
            File file = new File(path);
            Workbook workbook = null;
            try {
                InputStream inputStream = new FileInputStream(file);
                workbook = new XSSFWorkbook(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 1; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                String[] temp = new String[15];
                for (int index = 0; index < 15; index++) {
                    try {
                        row.getCell(index).setCellType(CellType.STRING);
                        temp[index] = row.getCell(index).getStringCellValue();
                    } catch (Exception e) {
                        temp[index] = "";
                    }
                }
                String srcDatabase = temp[0];
                String title = temp[1];
                String author = temp[2].substring(0,temp[2].length()-1);
                String organ = temp[3];
                String source = temp[4];
                String keyword = temp[5];
                String summary = temp[6];
                summary = summary.replaceAll(" ", "");
                String pubTime = temp[7];
                String firstDuty = temp[8];
                String fund = temp[9];
                String year = temp[10];
                String volume = temp[11];
                String period = temp[12];
                String pageCount = temp[13];
                String CLC = temp[14];
                int id = (int) paperRepo.count() + 1;
                Paper paper = new Paper(id,
                        title,
                        author,
                        organ,
                        source,
                        keyword,
                        summary,
                        pubTime,
                        firstDuty,
                        fund,
                        year,
                        volume,
                        period,
                        pageCount,
                        CLC,
                        srcDatabase);
                paperRepo.save(paper);
                statisticsRepo.save(new Statistics(id));
            }
            System.out.println("初始化数据完成！");
        }
    }
}
