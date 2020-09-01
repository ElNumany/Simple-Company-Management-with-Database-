
package Controls;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComboBox;


public class JMyComBo extends JComboBox {
    
    public JMyComBo(){
      
        setOpaque(false);
        
        
       
         
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(getBackground(Color.white));
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
        
    }
    
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }

    private Color getBackground(Color WHITE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
