package swing;

import javax.swing.*;


public class SButton extends JButton {

    private final String text;
    private String tip = "";
    int x,y;
    public SButton(String text, String tip, int x, int y){
        this.text=text;
        this.tip=tip;
        this.x=x;
        this.y=y;

        setBounds(x,y,200,100);
        setText(text);
        setToolTipText(tip);
        setActionCommand(text);
    }
    public SButton(String text, int x, int y){
        this.text=text;
        this.x=x;
        this.y=y;

        setBounds(x,y,200,100);
        setText(text);
        setActionCommand(text);
    }
}
