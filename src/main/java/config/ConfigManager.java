package config;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private static ConfigManager configManager;
    private static Map<String, String> properties = new HashMap<>();

    private ConfigManager() throws IOException {
        FileInputStream file = new FileInputStream("src/main/resources/testdata.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("config");
        
        for (Row row : sheet) {
            Cell keyCell = row.getCell(0);
            Cell valueCell = row.getCell(1);
            properties.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
        }
        workbook.close();
    }

    public static ConfigManager getInstance() {
        if (configManager == null) {
            synchronized (ConfigManager.class) {
                try {
                    configManager = new ConfigManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return configManager;
    }

    public String getProperty(String key) {
        return properties.get(key);
    }
}
