/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import companytest.Tools;
import javax.swing.JTable;

/**
 *
 * @author 9I1
 */
public class WorkOn implements MainData{
    private int EMPNO ;
    private int PROJECTNO;

    public int getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(int EMPNO) {
        this.EMPNO = EMPNO;
    }

    public int getPROJECTNO() {
        return PROJECTNO;
    }

    public void setPROJECTNO(int PROJECTNO) {
        this.PROJECTNO = PROJECTNO;
    }

    @Override
    public void add() {
        String StrInsert = "insert into workon values("
                + EMPNO + ","
                + PROJECTNO +")";
        boolean IsAdded = DB.Go.runNonQuery(StrInsert);
        if(IsAdded) {
            Tools.msgBox("Work On Is Added");
        }

    }

    @Override
    public void update() {
Tools.msgBox("Update Method not working in workon Class!");    }

    @Override
    public void delete() {

     String   StrDelete = "Delete From workon where EMPNO=" + EMPNO 
             + " and PROJECTNO =" + PROJECTNO ;
     boolean IsDeleted = DB.Go.runNonQuery(StrDelete);
     if(IsDeleted){
     Tools.msgBox("Work On Is Deleted!");
     }
    }

    @Override
    public String getAutoNumber() {

        Tools.msgBox("Update Method not working in WORKON Class!"); 
        return "";
    }

    @Override
    public void getAllRows(JTable Table) {

        DB.Go.fillToJTable("workon_data",Table);
        }

    @Override
    public void getOneRow(JTable Table) {

        String StrSelect = "SELECT * FROM workon_data WHERE EMPNO = " + EMPNO + " AND PROJECTNO = " + PROJECTNO ;
        DB.Go.fillToJTable(StrSelect, Table);
    }

    @Override
    public void getCustomRows(String Statment, JTable Table) {

        DB.Go.fillToJTable(Statment, Table);   
    }

    @Override
    public String getValueByName(String name) {
Tools.msgBox("Update Method not working in WORKON Class!");    
return "";    }

    @Override
    public String getNameByValue(String Value) {
Tools.msgBox("Update Method not working in WORKON Class!");  
    return "" ;
    }
    
    
}
