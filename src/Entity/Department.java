/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import companytest.Tools;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author 911
 */
public class Department implements MainData{
    private int DEPTNO;
    private String DEPTNAME;
    private String Location;

    public int getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(int DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    public String getDEPTNAME() {
        return DEPTNAME;
    }

    public void setDEPTNAME(String DEPTNAME) {
        this.DEPTNAME = DEPTNAME;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public void add() {
       
        String Strinsert = "INSERT INTO department VALUES (" 
		       + DEPTNO   + "," 
		 + "'" + DEPTNAME + "',"
		 + "'" + Location + "')";
        boolean IsAdd = DB.Go.runNonQuery(Strinsert);
        if (IsAdd){
        Tools.msgBox("Department Is Add");
        }
    
        }
    

    @Override
    public void update() {
        String StrUpdate = "update department set "
               + "DEPTNAME='"    + DEPTNAME + "',"
               + "LOCATION='"    + Location + "'"	 
               + "where DEPTNO=" + DEPTNO ;
        boolean isupdate = DB.Go.runNonQuery(StrUpdate);
        if(isupdate){
        Tools.msgBox("Department is updated");
        }
    
    }

    @Override
    public void delete() {
    
        String Strdelete = "DELETE FROM department "
                + " WHERE DEPTNO = " + DEPTNO ;
                
          boolean isdelete = DB.Go.runNonQuery(Strdelete);
          if(isdelete){
          Tools.msgBox("Department is deleted!");
          }
				
    }

    @Override
    public String getAutoNumber() {
        return DB.Go.getAutoNumber("department", "DEPTNO");
         
    }

    @Override
    public void getAllRows(JTable Table) {
    DB.Go.fillToJTable("department", Table);
    }

    @Override
    public void getOneRow(JTable Table) {
        String StrSelect = "SELECT * FROM `department` WHERE DEPTNO = " + DEPTNO;
        DB.Go.fillToJTable(StrSelect, Table);
    }

    @Override
    public void getCustomRows( String Statment, JTable Table) {
        DB.Go.fillToJTable(Statment, Table);
    }

    @Override
    public String getValueByName(String name) {
        String StrSelect = "Select DEPTNO from department "
                + "where DEPTNAME='" + name + "'";
        String StrVal =(String) DB.Go.getTableData(StrSelect).Items[0][0];
        return StrVal;
    }

    @Override
    public String getNameByValue(String Value) {
        String StrSelect = " select DEPTNAME from department where DEPTNO = " + Value;
        String StrName = (String) DB.Go.getTableData(StrSelect).Items[0][0];
    
        return StrName;
    }

   
    
}
