package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import gui.menu.*;
public class SlotLabel extends ColoredLabel {
	
	private String adress;
	
	public SlotLabel(String adress) {
    	super("                    ", Color.WHITE, RIGHT);
        this.adress = adress;
    }
    
    public String getAdress() {
    	return adress;
    }
}
