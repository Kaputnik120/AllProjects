/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.uli.konto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Uli
 */
public class ExcelDataHolder implements Serializable{
    
    private List<ExcelData> excelDataList;

    /**
     * @return the excelDataList
     */
    public List<ExcelData> getExcelDataList() {
        return excelDataList;
    }

    /**
     * @param excelDataList the excelDataList to set
     */
    public void setExcelDataList(List<ExcelData> excelDataList) {
        this.excelDataList = excelDataList;
    }

}
