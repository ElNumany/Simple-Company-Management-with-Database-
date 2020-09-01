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
 * @author 911
 */
public class Employee implements MainData{
    private int    EMPNO;
    private String EMPNAME;
    private String EMPADD;
    private double EMPSALARY;
    private String EMPHIRDATE;
    private String BIRTHDATE;
    private int    DEPTNO;

    public int getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(int EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getEMPNAME() {
        return EMPNAME;
    }

    public void setEMPNAME(String EMPNAME) {
        this.EMPNAME = EMPNAME;
    }

    public String getEMPADD() {
        return EMPADD;
    }

    public void setEMPADD(String EMPADD) {
        this.EMPADD = EMPADD;
    }

    public double getEMPSALARY() {
        return EMPSALARY;
    }

    public void setEMPSALARY(double EMPSALARY) {
        this.EMPSALARY = EMPSALARY;
    }

    public String getEMPHIRDATE() {
        return EMPHIRDATE;
    }

    public void setEMPHIRDATE(String EMPHIRDATE) {
        this.EMPHIRDATE = EMPHIRDATE;
    }

    public String getBIRTHDATE() {
        return BIRTHDATE;
    }

    public void setBIRTHDATE(String BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }

    public int getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(int DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

        @Override
    public void add() {
       
        String Strinsert = "INSERT INTO employee VALUES (" 
		       + EMPNO      + "," 
		 + "'" + EMPNAME    + "',"
		 + "'" + EMPADD     + "',"
                 +       EMPSALARY  + ","
                 + "'" + EMPHIRDATE + "' ,"
                 + "'" + BIRTHDATE  + "',"
                 +     + DEPTNO     + ")";
        boolean IsAdd = DB.Go.runNonQuery(Strinsert);
        if (IsAdd){
        Tools.msgBox("Employee Is Add");
        }
    
        }
    @Override
    public void update() {
      String StrUpdate = "update employee set " 
		 + "EMPNAME='"      + EMPNAME    + "',"
                 + "EMPADD='"       + EMPADD     + "',"	 
                 + "EMPSALARY="     + EMPSALARY  + ","
                 + "EMPHIRDATE='"   + EMPHIRDATE + "',"
                 + "BIRTHDATE='"    + BIRTHDATE  + "',"
                 + "DEPTNO="        + DEPTNO 
                 + " WHERE EMPNO ="   + EMPNO ;
        boolean IsAdd = DB.Go.runNonQuery(StrUpdate);
        if (IsAdd){
        Tools.msgBox("Employee Is Updated");
        }
    }
    
    
    @Override
    public void delete() {
         String Strdelete = " DELETE FROM employee WHERE EMPNO=" + EMPNO ;
                
          boolean isdelete = DB.Go.runNonQuery(Strdelete);
          if(isdelete){
          Tools.msgBox("Employee is deleted!");
          }
    }
        

    @Override
    public String getAutoNumber() {
         return DB.Go.getAutoNumber("employee", "EMPNO");
    }

    @Override
    public void getAllRows(JTable Table) {
        DB.Go.fillToJTable("employee", Table);
    }

    @Override
    public void getOneRow(JTable Table) {
         String StrSelect = "SELECT * FROM `employee` WHERE EMPNO = " + EMPNO;
        DB.Go.fillToJTable(StrSelect, Table);
    }

    @Override
    public void getCustomRows(String Statment, JTable Table) {
        DB.Go.fillToJTable(Statment, Table);
    }

    @Override
    public String getValueByName(String name) {
        
        String StrSelect = "Select EMPNO from employee "
                + "where EMPNAME='" + name + "'";
        String StrVal =(String) DB.Go.getTableData(StrSelect).Items[0][0];
        return StrVal;
    }

    @Override
    public String getNameByValue(String Value) {
         String StrSelect = "select EMPNAME from employee where EMPNO = " + Value;
        String StrName = (String) DB.Go.getTableData(StrSelect).Items[0][0];
    
        return StrName;
    }
    
    
}
