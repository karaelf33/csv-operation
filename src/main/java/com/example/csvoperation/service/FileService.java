package com.example.csvoperation.service;

import com.example.csvoperation.service.impl.FileServiceImpl;
import com.example.csvoperation.utils.ColorCode;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Service
public class FileService implements FileServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    public String readXLSFile() {
        try {
            FileInputStream file = new FileInputStream("TimeZoneData.xlsx");
            ZoneId lagos = ZoneId.of("Africa/Lagos");
            LocalTime lagosTime = LocalTime.now(lagos);
            DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("hh--mm--ss");

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (dateTimeFormatter3.format(lagosTime).equals(cell.getStringCellValue())) {
                        System.out.println(ColorCode.Cyan + "CONGRATULATIONS :d :d<<<<<The action be done at the current time in Lagos: " +
                                ColorCode.Red + "Clock: " + cell.getRow().getCell(0) +
                                ColorCode.Magenta + " Day: " + cell.getRow().getCell(1)+" >>>>>>>>");
                    } else {
                        System.out.println(ColorCode.Red + "NO ACTION FOR "+ cell.getRow().getCell(1)+" !!!!!");
                    }

                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Reading file...";
    }

    public String createFile() {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Time Zone data Data");
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("hh--mm--ss");
        ZoneId zoneIdRome = ZoneId.of("Europe/Rome");
        ZoneId zoneNewYork = ZoneId.of("America/New_York");
        ZoneId zoneChicago = ZoneId.of("America/Chicago");
        ZoneId lagos = ZoneId.of("Africa/Lagos");
        ZoneId nDjamena = ZoneId.of("Africa/Ndjamena");
        ZoneId zoneSingapore = ZoneId.of("Asia/Singapore");
        ZoneId zoneCalcutta = ZoneId.of("Asia/Calcutta");


        LocalTime europeTime = LocalTime.now(zoneIdRome);
        LocalTime zoneNewYorkTime = LocalTime.now(zoneNewYork);
        LocalTime zoneChicagoTime = LocalTime.now(zoneChicago);
        LocalTime lagosTime = LocalTime.now(lagos);
        LocalTime nDjamenaTime = LocalTime.now(nDjamena);
        LocalTime zoneSingaporeTime = LocalTime.now(zoneSingapore);
        LocalTime zoneCalcuttaTime = LocalTime.now(zoneCalcutta);

        Map<String, DayOfWeek> data = new TreeMap<>();
        data.put(dateTimeFormatter3.format(europeTime), DayOfWeek.MONDAY);
        data.put(dateTimeFormatter3.format(zoneNewYorkTime), DayOfWeek.TUESDAY);
        data.put(dateTimeFormatter3.format(zoneChicagoTime), DayOfWeek.WEDNESDAY);
        data.put(dateTimeFormatter3.format(lagosTime), DayOfWeek.THURSDAY);
        data.put(dateTimeFormatter3.format(nDjamenaTime), DayOfWeek.FRIDAY);
        data.put(dateTimeFormatter3.format(zoneSingaporeTime), DayOfWeek.SATURDAY);
        data.put(dateTimeFormatter3.format(zoneCalcuttaTime), DayOfWeek.SUNDAY);

        Set<String> keyset = data.keySet();
        int rownum = 0;


        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);
            DayOfWeek dayOfWeek = data.get(key);
            Cell cell = row.createCell(0);
            Cell cell2 = row.createCell(1);
            cell.setCellValue(key);
            cell2.setCellValue(String.valueOf(dayOfWeek));


        }
        try {
            FileOutputStream out = new FileOutputStream("TimeZoneData.xlsx");
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "TimeZoneData.xlsx written successfully on disk.";
    }

}
