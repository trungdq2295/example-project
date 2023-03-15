package com.example.uploaddemo.excel;

import com.example.uploaddemo.model.command.VendorCommand;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelGenerator {

    private static List<VendorCommand> list =  new ArrayList<>();

    static {
        RandomDataGenerator random = new RandomDataGenerator();
        for(int i = 0; i < 200000; i ++){
            list.add(new VendorCommand(random.nextHexString(6), random.nextHexString(6), random.nextLong(0L,100L)));
        }
    }

    public void writeExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        System.out.println(System.currentTimeMillis());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Sheet sheet = workbook.createSheet("Persons");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 4000);

            Row header = sheet.createRow(0);

            CellStyle headerStyle = workbook.createCellStyle();
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);

            Cell headerCell = header.createCell(0);
            headerCell.setCellValue("Name");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(1);
            headerCell.setCellValue("Age");
            headerCell.setCellStyle(headerStyle);

            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            AtomicInteger rowNumber = new AtomicInteger(1);
            list.forEach(vendor -> {
                Row row = sheet.createRow(rowNumber.getAndIncrement());
                Cell cell = row.createCell(1);
                cell.setCellValue(vendor.getVendorName());
                cell = row.createCell(2);
                cell.setCellValue(vendor.getCountry());
                cell = row.createCell(3);
                cell.setCellValue(vendor.getProductId());
            });
            System.out.println(list.get(0));
            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";
            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);

        } finally {
            if (workbook != null) {
                workbook.close();
            }
            stopWatch.stop();
        }
        System.out.println(System.currentTimeMillis());
        stopWatch.prettyPrint();
    }

    public static void main(String[] args) {
        ExcelGenerator excelGenerator = new ExcelGenerator();
        try {
            excelGenerator.writeExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
