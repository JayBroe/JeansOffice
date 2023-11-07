package swing;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SCombo extends JComboBox {

    private int x,y;
    private Integer[] options;

    private String emt="";

    private String[] tips;

    private Integer[] tips1;
    private List<String> tips_info;

    private final Map<String, String> mapz = new HashMap<String, String>();

    public SCombo(Integer[] options, int x, int y){
        super(options);
        this.x=x;
        this.y=y;
        setBounds(x,y,200,30);
        setVisible(true);
    }

    public SCombo(Integer[] options, List<String> tips, int x, int y){
        super(options);
        this.options=options;
        this.tips= tips.toArray(new String[0]);
        this.x=x;
        this.y=y;
        set_info1();
        setBounds(x,y,200,30);
        setVisible(true);
    }

    public void set_info(){
        mapz.put(Arrays.toString(options), tips.toString());
        for(int i =0;i<mapz.size();){
            setToolTipText("cyc");
        }
        setToolTipText("cyc");
    }
    public void set_info1(){
        for(int i =0;i<options.length;i++){
            emt+=options[i] + " : " + tips[i]+" | ";
        }
        setToolTipText(emt);
    }

    public void set_info2(){
        for(int i =0;i<2;i++){
            emt+=options[i] + " : " + tips[i]+" | ";
        }
        setToolTipText(emt);
    }
    public int returnX(){
        return this.x;
    }
    public int returnY(){
        return this.y;
    }
}
