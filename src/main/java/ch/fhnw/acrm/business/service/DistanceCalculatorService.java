package ch.fhnw.acrm.business.service;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

//Autor: Lennart


@Service
public class DistanceCalculatorService {


    public int getDistance(String ZIPCode) throws Exception {

        //Read and create sheet from excel
        ClassPathResource classPathResource = new ClassPathResource("Distances.xlsx");
        File DistanceFile = classPathResource.getFile();
        FileInputStream Input = new FileInputStream(DistanceFile);
        XSSFWorkbook workbook = new XSSFWorkbook(Input);
        XSSFSheet sheet =  workbook.getSheet("Distances");

        //Create Hashmap from sheet
        int rows = sheet.getLastRowNum();
        HashMap<String,String> Distances = new HashMap<String,String>();

        //Storing data to Hashmap
        for(int i = 1; i<=rows; i++) {
           String key = sheet.getRow(i).getCell(0).getRawValue();
           String value = sheet.getRow(i).getCell(1).getRawValue();
           Distances.put(key, value);
        }

        //Retrieve the kilometers from Hashmap
        String SearchKey = ZIPCode;
        String SearchResult = Distances.get(SearchKey);
        int TravelDistance;

        if (SearchResult == null) {
            throw new Exception("Uncommon ZIPCode: " + ZIPCode);
        } else {
            TravelDistance = Integer.parseInt(SearchResult);
            return TravelDistance;
        }
    }
}
