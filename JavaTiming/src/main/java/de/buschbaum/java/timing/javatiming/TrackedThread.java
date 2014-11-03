package de.buschbaum.java.timing.javatiming;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Does some calcululations repeatedly and outputs the time taken in an
 * Excel-sheet.
 *
 * @author uli
 */
public class TrackedThread extends Thread {

    private static final String WORKBOOK_LOCATION = "/home/uli/Dokumente/IT/Entwicklung/Java/Timing/wb1.xls";
    private static final String WORKSHEET_NAME = "data";
    private static final int EXECUTION_TIMES = 500000;
    private static final int WARMUP_EXECUTION_TIMES = 50000;

    @Override
    public void run() {
        try {
            //Create Workbook
            Workbook wb = createWorkbook(WORKBOOK_LOCATION);

            //Warmup JIT
            doWorkAndLogTimes(WARMUP_EXECUTION_TIMES);

            //Do work and get tracked execution times
            List<Integer> values = doWorkAndLogTimes(EXECUTION_TIMES);

            //Write the tracked execution times to the workbook
            addDataToWorkbook(wb, WORKSHEET_NAME, values);

            //Save changes to the workbook
            saveWorkbook(wb, WORKBOOK_LOCATION);
        } catch (IOException ex) {
            System.out.print(ex);
        }
    }

    /**
     * Does some processing repeatedly and tracks execution time.
     *
     * @return
     */
    public static List<Integer> doWorkAndLogTimes(int times) {
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < EXECUTION_TIMES - 1; i++) {
            long startTime = System.nanoTime();
            doWork();
            long endTime = System.nanoTime();
            int executionTime = (int) (endTime - startTime) / 1000;
            System.out.println("ExecTime: " + executionTime);
            values.add(executionTime);
        }

        return values;

    }

    /**
     * Does an processing intensive task
     */
    public static void doWork() {
        
        double atan1 = Math.atan(Math.random());
        double atan2 = Math.atan(Math.random());
        double atan3 = Math.atan(Math.random());
        double atan4 = Math.atan(Math.random());
        System.out.println(atan1);
        System.out.println(atan2);
        System.out.println(atan3);
        System.out.println(atan4);

    }

    /**
     * Creates a workbook
     *
     * @param location
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Workbook createWorkbook(String location) throws IOException {
        Workbook wb = new XSSFWorkbook();
        saveWorkbook(wb, location);
        return wb;
    }

    /**
     * Writes a workbook to disk
     *
     * @param wb
     * @param location
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveWorkbook(Workbook wb, String location) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(location);
        wb.write(fileOut);
        fileOut.close();
    }

    /**
     * Adds a list of integers to the given worksheet and workbook
     *
     * @param wb
     * @param worksheetName
     * @param values
     */
    public static void addDataToWorkbook(Workbook wb, String worksheetName, List<Integer> values) {
        Sheet sheet = wb.createSheet(worksheetName);

        for (int i = 0; i < values.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(values.get(i));
        }

        sheet.getRow(0).createCell(5).setCellFormula("MIN($A$1:$A$" + EXECUTION_TIMES + ")");
        sheet.getRow(1).createCell(5).setCellFormula("MAX($A$1:$A$" + EXECUTION_TIMES + ")");
        sheet.getRow(2).createCell(5).setCellFormula("AVERAGE($A$1:$A$" + EXECUTION_TIMES + ")");
    }
}
