package swing;

import javax.swing.*;

public class SLabel extends JLabel {
    int x,y;
    private String text;
    public SLabel(String text,int x, int y) {
        this.text=text;
        this.x=x;
        this.y=y;
        setBounds(x-50,y,200,30);
        setText(text);
        setVisible(true);
    }
}
