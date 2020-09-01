
package DB;


import companytest.Tools;
import companytest.Tools.Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Go {
    private static String url = "";
    private static Connection con;
   
    
    private static void SetUrl(){
    
    url = "jdbc:mysql://localhost:3306/company2";
    }
    private static void SetConnection(){
        SetUrl();
        try {
            con= DriverManager.getConnection(url,"root","");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
        }
    
      
    
    }
    public static boolean checkUserAndPass(String Username , String Password){
    
    try{
        SetConnection();
        Statement stmt = con.createStatement();
        String strCheck = "select * from users where username='" + Username + "' AND" 
                +" Password ='" + Password + "'";
        stmt.executeQuery(strCheck);
        while ( stmt.getResultSet().next() ){
        con.close();
            return true;
        }
    con.close();
    
    }
    catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    
    }
    return false;
    }
    
    public static boolean runNonQuery(String SqlStatment){
    try{
    SetConnection();
    Statement stmt = con.createStatement();
    stmt.execute(SqlStatment);
    con.close();
    return true;
    
    }
    catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    
    return false;
    }
    
    }
    public static String getAutoNumber(String TableName , String CouloumName){
    
    
    try{
        SetConnection();
        Statement Stmt = con.createStatement();
        String StrAuto = "Select max(" + CouloumName +")+1 AS autoNum"
                + " from " + TableName ;
        Stmt.executeQuery(StrAuto);
        String num= "";
        while (Stmt.getResultSet().next()){
        
            num = Stmt.getResultSet().getString("autonum");
            
        
        }
    con.close();
    if(num==null || "".equals(num)){
    return "1";
    }
    else{
    return num;
    }
    }
    catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex);
    return "0"; 
    }
    
    }
    public static Table getTableData(String Statement){
    
        Tools t = new Tools();
        try{
        
            SetConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(Statement);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();
            
            Table table = t.new Table(c);
            while(rs.next()){
            Object row[] = new Object[c];
            for(int i = 0 ;i < c ;i++){
            
                row[i] = rs .getString(i+1);
            
            }
            table.addNewRow(row);
            }
            con.close();
            return table;
        }
        catch(SQLException ex){
        Tools.msgBox(ex.getMessage());
        return t.new Table(0);
        }
    
    }

    
    @SuppressWarnings({"unchecked", "unchecked"})
    public static void fillCombo(String TableName , String ColoumName , JComboBox Combo){
        try{
            
        SetConnection();
        Statement stmt = con.createStatement();
        ResultSet rs ;
        String StrSelect = "select " + ColoumName + " from " + TableName;
        
        rs= stmt.executeQuery(StrSelect);
        rs.last(); 
        int C = rs.getRow(); 
        rs.beforeFirst();
        
        
        
        //EROOR NOT Shown IN COMPO BOX !
        
        
        String Values [] = new String[C];
        while(rs.next()){
        int i = 0;
        Values[i] = rs.getString(1);
        i++;
        }
        con.close();
        
        Combo.setModel(new DefaultComboBoxModel(Values));
        
        }
        catch(SQLException ex){
        Tools.msgBox(ex.getMessage());
        }
        
    
    }
    public static void fillToJTable(String TableNameorSelectStatement,JTable Table){
    try{
    SetConnection();
    Statement stmt = con.createStatement();
    ResultSet rs;
    String SPart= TableNameorSelectStatement.substring(0,7).toLowerCase();
    String StrSelect;
    if("select ".equals(SPart)){
    StrSelect=TableNameorSelectStatement;
    }
    
    else {
            StrSelect = "SELECT * from " + TableNameorSelectStatement;
            }
    rs = stmt.executeQuery(StrSelect);
    
    ResultSetMetaData RSMD = rs.getMetaData();
    int c = RSMD.getColumnCount();
    
        DefaultTableModel DTM = (DefaultTableModel) Table.getModel();
         Vector row = new Vector();
        DTM.setRowCount(0);
        
        while (rs.next()) {
        row = new Vector(c);
        for(int i = 1 ; i<=c ; i++){
        row.add(rs.getString(i));
        }
        DTM.addRow(row);
        }
        if(Table.getColumnCount() != c){
        Tools.msgBox("JTable Couloms Count Not Equal To Query Couloms Count\n JTable Colums Count Is : " + Table.getColumnCount()+"\n Query Colums Count Is: " + c);
        }
    con.close();
    }
   
    catch(SQLException ex){
    Tools.msgBox(ex.getMessage());
    }
        
    }
    
}


