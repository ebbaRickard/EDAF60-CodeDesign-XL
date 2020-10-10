package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CurrentLabel extends ColoredLabel{

    public CurrentLabel() {
        super("A1", Color.WHITE);
        
    }
    
    public void setLabel(String s) {
    	this.setText(s);
    }

}
    

