package com.example.diplom;

import com.example.diplom.models.Group;
import com.example.diplom.models.StreamsAutumn;
import com.example.diplom.models.StreamsCoursesAutumn;
import com.example.diplom.repository.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    private static void processCell(Cell cell, List<Object> dataRow) {
        switch (cell.getCellType()) {
            case STRING:
                dataRow.add(cell.getStringCellValue());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    dataRow.add(cell.getLocalDateTimeCellValue());
                } else {
                    dataRow.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
                break;
            case BOOLEAN:
                dataRow.add(cell.getBooleanCellValue());
                break;
            case FORMULA:
                dataRow.add(cell.getCellFormula());
                break;
            default:
                dataRow.add("");
        }
    }
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:/Users/Владислав/Desktop/универ/4 курс/Диплом/Відомість_учбових_доручень_321_PIITU_2022_2023_020822.xls");
        Workbook wb = new HSSFWorkbook(fis);
        var sheetIterator = wb.sheetIterator();
        int list = 1;
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            if (list == 2) {
                System.out.println("Autumn");
                var data = new HashMap<Integer, List<Object>>();
                var iterator = sheet.rowIterator();
                int i = 0;
                for (var rowIndex = 0; iterator.hasNext(); rowIndex++) {
                    var row = iterator.next();
                    if (i > 6) {
                        data.put(rowIndex, new ArrayList<>());
                        if (row.getCell(0).toString().isEmpty()) break;
                        for (var cell : row) {
                            processCell(cell, data.get(rowIndex));
                        }
                    }
                    i++;
                }
                list++;
                for (Map.Entry<Integer, List<Object>> entry : data.entrySet()) {
                    List<Object> value = entry.getValue();
                    if (value.isEmpty()) break;
                    System.out.println(value);
                }
            } else {
                System.out.println("Spring");
                var data = new HashMap<Integer, List<Object>>();
                var iterator = sheet.rowIterator();
                int i = 0;
                for (var rowIndex = 0; iterator.hasNext(); rowIndex++) {
                    var row = iterator.next();
                    if (i > 6) {
                        data.put(rowIndex, new ArrayList<>());
                        if (row.getCell(0).toString().isEmpty()) break;
                        for (var cell : row) {
                            processCell(cell, data.get(rowIndex));
                        }
                    }
                    i++;
                }
                list++;
                for (Map.Entry<Integer, List<Object>> entry : data.entrySet()) {
                    List<Object> value = entry.getValue();
                    if (value.isEmpty()) break;
                    System.out.println(value);
                }
            }
        }
        fis.close();
        FileInputStream file = new FileInputStream(new File("studyload_rozpodil_template.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        Row row = sheet.createRow(10);
        Cell cell = row.createCell(0);
        cell.setCellValue("Test1");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("Test2");
        cell.setCellStyle(style);
        row = sheet.createRow(11);
        cell = row.createCell(0);
        cell.setCellValue("Test3");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("Test4");
        cell.setCellStyle(style);
        FileOutputStream outputStream = new FileOutputStream("createExcel.xlsx");
        workbook.write(outputStream);
        workbook.close();
    }
}
