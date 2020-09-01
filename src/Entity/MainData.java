
package Entity;

import javax.swing.JTable;


public interface MainData {
    public void add();
    public void update();
    public void delete();
    public String getAutoNumber();
    public void getAllRows(JTable Table);
    public void getOneRow(JTable Table);
    public void getCustomRows(String Statment,JTable Table);
    public String getValueByName (String name);
    public String getNameByValue (String Value);
    
}
