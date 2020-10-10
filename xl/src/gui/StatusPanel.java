package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import gui.menu.Controller;

public class StatusPanel extends BorderPanel {

    protected StatusPanel(StatusLabel statusLabel) {
        add(WEST, new CurrentLabel());
        add(CENTER, statusLabel);
    }
    
    public CurrentLabel getCurrentLabel() {
    	return (CurrentLabel) this.getComponent(0);  
    }
    public StatusLabel getStatusLabel() {
    	return (StatusLabel) this.getComponent(1);
    }
}
