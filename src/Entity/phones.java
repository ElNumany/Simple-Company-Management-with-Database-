
package Entity;

import com.sun.org.apache.bcel.internal.generic.DUP;
import companytest.Tools;
import javax.swing.JTable;


public class phones implements MainData {
    private int EMPNO ;
    private String Phone;
    

    public int getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(int EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public void add() {
     String strInsert = "insert into phones values (" 
              + EMPNO + ",'" + Phone + "')";
                 boolean IsAdd = DB.Go.runNonQuery(strInsert);
    
                 if (IsAdd ){
        
      //  Tools.msgBox("Phone Is Added!");
    
    }
    }
 
    

    @Override
    public void update() {
        Tools.msgBox("update Method In Employee Class Not Working! ");
     }

    @Override
    public void delete() {
        String StrDelete = "delete from phones where EMPNO =" + EMPNO
                         + " and phones='" +Phone+"'";
        boolean IsDelete= DB.Go.runNonQuery(StrDelete);
        if(IsDelete){
       // Tools.msgBox("Phone Is deleted!");}
               
        
       }
    }
    
    public void deleteByEmp(){
    
        String StrDelete = "Delete from phones where EMPNO="+EMPNO;
        boolean IsDeleted = DB.Go.runNonQuery(StrDelete);
        if (IsDeleted){
        //Tools.msgBox("AllPhones is deleted!");
        
        }
        
    
    }
    @Override
    public String getAutoNumber() {
        
        Tools.msgBox("getAutoNumbers Not Runs!");
        return "";
    }

    @Override
    public void getAllRows(JTable Table) {
String StrSelect = "Select phone from phones where EMPNO=" + EMPNO;

DB.Go.fillToJTable(StrSelect, Table);

    }

    @Override
    public void getOneRow(JTable Table) {
Tools.msgBox("getOneRow Not Runs!");
       
    }

    @Override
    public void getCustomRows(String Statment, JTable Table) {
Tools.msgBox("getCustomRows Not Runs!");    }

    @Override
    public String getValueByName(String name) {
Tools.msgBox("getValueByName Not Runs!");  
return"";
    }

    @Override
    public String getNameByValue(String Value) {
Tools.msgBox("getNameByValue Not Runs!");  
return "";
    }
    
    public String getEMPNObyPhone(String requestPhone){
    String StrSelect = "select EMPNO from phones "+
            "where phone ='" + requestPhone + "'";
    Object row [] [] = DB.Go.getTableData(StrSelect).Items;
    String StrEMPNO = "";
    if (row.length>0){
    StrEMPNO = (String) row[0][0];
    
    }
    else{
    StrEMPNO = "0";
    
    }
    return StrEMPNO;
}
}
