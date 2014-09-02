/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.uli.konto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Uli
 */
public class ExcelParser {

    public static ExcelDataHolder parseExcelFiles(List<File> excelFiles) {
        if (excelFiles == null) {
            throw new NullPointerException("List of excelFiles may not be null!");
        }

        ExcelDataHolder excelDataHolder = new ExcelDataHolder();

        for (File excelFile : excelFiles) {
            if (excelFile.canRead()) {
                System.out.println("Parsing : " + excelFile.getName());
                try {
                    List<ExcelData> excelDataList = parseExcelFile(excelFile);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
                }


                System.out.println("Parsing ended : " + excelFile.getName());
            }
        }

        return null;
    }

    public static List<ExcelData> parseExcelFile(File excelFile) throws FileNotFoundException, IOException {
        System.out.println("");
        System.out.println("------------------------------------------------------------");
        System.out.println("");
        FileInputStream fileInputStream = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        Iterator<XSSFSheet> worksheetIterator = workbook.iterator();
        if (worksheetIterator.hasNext()) {
            XSSFSheet worksheet = worksheetIterator.next();
            Iterator<Row> rowIterator = worksheet.iterator();
            while (rowIterator.hasNext()) {
                System.out.println("");
                System.out.println("-----------------------");
                System.out.println("");
                Row currentRow = rowIterator.next();
                if (isDataRow(currentRow)) {
                    ExcelData excelData = new ExcelData();
                } else {
                    System.out.println("Row " + currentRow.getRowNum() + " from file " + excelFile.getName() + " isn´t a data row.");
                }
            }
        }
        return null;
    }

    public static boolean isDataRow(Row row) {
        if (row == null) {
            throw new RuntimeException("row may not be null!");
        }
        short lastCellNum = row.getLastCellNum();
        short firstCellNum = row.getFirstCellNum();
        System.out.println("The lastcell for row " + row.getRowNum() + " is " + lastCellNum);
        System.out.println("The firstcell for row " + row.getRowNum() + " is " + firstCellNum);

        if (firstCellNum != 0) {
            System.out.println("The row " + row.getRowNum() + " isn´t valid, because the first Cell isn´t 0 !");
            return false;
        }
        if (lastCellNum > 10) {
            System.out.println("The row " + row.getRowNum() + " isn´t valid, because the last Cell is greater 10!");
            return false;
        }

        for (int i = 0; i < lastCellNum; i++) {
            System.out.println("");
            System.out.println("-------");
            System.out.println("");
            Cell currentCell = row.getCell(i);
            System.out.println("currentCell is " + currentCell);
            if (currentCell != null) {
                switch (i) {
                    case 0:
                    case 1:
                        //Datum
                        if (currentCell.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                            System.out.println("The " + i + ". column of row " + row.getRowNum() + " isn´t valid, because it´s not Numeric(will be parsed to Date). Current cell type is: " + currentCell.getCellType());
                            return false;
                        }
                        break;
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 9:
                        //Text
                        if (currentCell.getCellType() != Cell.CELL_TYPE_STRING && 
                                currentCell.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                            System.out.println("The " + i + ". column of row " + row.getRowNum() + " isn´t valid, because it´s not a String or a number. Current cell type is: " + currentCell.getCellType());
                            return false;
                        }
                        break;
                    case 8:
                        //Zahl
                        if (currentCell.getCellType() != Cell.CELL_TYPE_NUMERIC) {

                            System.out.println("The " + i + ". column of row " + row.getRowNum() + " isn´t valid, because it´s not a String (will be parsed to Double). Current cell type is: " + currentCell.getCellType());
                            return false;
                        }
                        break;
                    case 4:
                    case 5:
                    //Empty
                }
            }
        }
        return true;
    }

    public static List<File> getFileList() {
        List<File> fileList = new ArrayList<File>();
        URL classLocation = ExcelParser.class.getProtectionDomain().getCodeSource().getLocation();
        File classFolder = new File(classLocation.getFile());
        File dataFolder = new File(classFolder.getParentFile().getParentFile().getPath() + "/data");

        File[] excelFileArray = dataFolder.listFiles();

        for (int i = 0; i < excelFileArray.length; i++) {
            File currentFile = excelFileArray[i];
            if (currentFile.getName().endsWith(".xlsx")) {
                fileList.add(currentFile);
            }
        }
        return fileList;
    }

    public static ExcelDataHolder setCategories(ExcelDataHolder excelDataHolder) {
        return null;
    }
}
