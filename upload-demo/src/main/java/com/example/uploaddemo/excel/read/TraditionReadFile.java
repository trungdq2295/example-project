package com.example.uploaddemo.excel.read;

import com.example.uploaddemo.model.command.VendorCommand;
import com.example.uploaddemo.repository.VendorRepository;
import com.example.uploaddemo.service.VendorService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TraditionReadFile {

    private static List<VendorCommand> list = new ArrayList<>();

    @Autowired
    VendorService vendorService;

    public void readFile() {
        System.out.println(System.currentTimeMillis());
        try {
            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";
            File file = new File(fileLocation);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            Map<Integer, List<String>> data = new HashMap<>();
            VendorCommand vendor;
            for (Row row : sheet) {
                vendor = new VendorCommand();
                for (Cell cell : row) {
                    switch (cell.getColumnIndex()) {
                        case 0:
//                            vendor.setId((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            vendor.setVendorName(cell.getStringCellValue());
                            break;
                        case 2:
                            vendor.setCountry(cell.getStringCellValue());
                            break;
                        case 3:
                            vendor.setProductId((long) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                }
                list.add(vendor);
            }
        } catch (IOException | InvalidFormatException ex) {
            System.out.println("Can not file find");
        } finally {

        }
        System.out.println(System.currentTimeMillis());
        vendorService.saveAll(list);
    }

    public static void main(String[] args) {
        TraditionReadFile traditionReadFile = new TraditionReadFile();
        traditionReadFile.readFile();
    }
}
