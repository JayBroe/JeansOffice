package swing;

import javax.swing.*;
import java.util.Arrays;

public class STextField extends JTextField {
    private int x,y;
    public STextField(int x, int y){
        this.x=x;
        this.y=y;
        setBounds(x,y,200,30);
        setVisible(true);
    }
    public STextField(String[] tip, int x, int y){
        this.x=x;
        this.y=y;
        setToolTipText(Arrays.toString(tip));
        setBounds(x,y,200,30);
        setVisible(true);
    }
    public STextField(String tip, int x, int y){
        this.x=x;
        this.y=y;
        setToolTipText(Arrays.toString(tip.toCharArray()));
        setBounds(x,y,200,30);
        setVisible(true);
    }
    public int returnX(){
        return this.x;
    }
    public int returnY(){
        return this.y;
    }

}
