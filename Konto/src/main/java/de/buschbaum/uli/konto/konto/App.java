package de.buschbaum.uli.konto.konto;

import de.buschbaum.uli.konto.ExcelDataHolder;
import de.buschbaum.uli.konto.ExcelParser;
import java.io.File;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<File> fileList = ExcelParser.getFileList();
        ExcelDataHolder excelDataHolder = ExcelParser.parseExcelFiles(fileList);
    }
}
