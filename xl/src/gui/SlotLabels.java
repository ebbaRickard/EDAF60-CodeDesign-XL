package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;

import gui.menu.Controller;

public class SlotLabels extends GridPanel {

    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel(ch+Integer.toString(row));
                add(label);
                labelList.add(label);
            }
        }

    }
    
    public List<SlotLabel> getSlotLabels(){
    	return this.labelList;
    }
    

}
