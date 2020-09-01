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
public class Project implements MainData {
    private int ProjectNO ; 
    private String ProjectName;
    private String Location;
    private int DEPTNO;

    public int getProjectNO() {
        return ProjectNO;
    }

    public void setProjectNO(int ProjectNO) {
        this.ProjectNO = ProjectNO;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(int DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    @Override
    public void add() {
    
      String  StrInsert = " insert into project values ("
                +ProjectNO   + ",'"
                +ProjectName +"','" 
                +Location    + "',"
                +DEPTNO + ")";
      boolean IsAdd= DB.Go.runNonQuery(StrInsert);
      if(IsAdd){
          Tools.msgBox("Project Is Added!");
      }
    }

    @Override
    public void update() {

        String StrUpdate = "update project set " 
                + "PRONAME ='" + ProjectName + "'," 
                + "PROLOCATION ='" + Location + "'," 
                + "DEPTNO=" + DEPTNO 
                + "where PROJECTNO = " + ProjectNO ;
          boolean IsUpdate = DB.Go.runNonQuery(StrUpdate);
      if(IsUpdate){
          Tools.msgBox("Project Is Updated!");
      }
    }

    @Override
    public void delete() {

        String StrDelete = "DELETE FROM project WHERE PROJECTNO =" + ProjectNO;
        boolean Isdeleted = DB.Go.runNonQuery(StrDelete);
      if(Isdeleted){
          Tools.msgBox("Project Is Deleted!");
        }
    }

    @Override
    public String getAutoNumber() {
       
        return DB.Go.getAutoNumber("project", "PROJECTNO");
    
    }

    @Override
    public void getAllRows(JTable Table) {
      DB.Go.fillToJTable("project",Table);
    }

    @Override
    public void getOneRow(JTable Table) {
        String StrSelect = "Select * from project where PROJECTNO =" +ProjectNO ;
        DB.Go.fillToJTable(StrSelect, Table);
                }

    @Override
    public void getCustomRows(String Statment, JTable Table) {
     DB.Go.fillToJTable(Statment, Table);
    }

    @Override
    public String getValueByName(String name) {
   String StrSelect = "SELECT PROJECTNO FROM project where PRONAME='" + name + "'";
   String StrVal = (String) DB.Go.getTableData(StrSelect).Items[0][0];
   return StrVal;
           }

    @Override
    public String getNameByValue(String Value) {
        String StrSelect = "select PRONAME from project where PROJECTNO =" + Value;
        String StrName = (String) DB.Go.getTableData(StrSelect).Items[0][0];
        return StrName;
        
      

    }
    
}
