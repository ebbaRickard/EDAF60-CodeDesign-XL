package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import java.util.List;

public class SheetPanel extends BorderPanel {

    public SheetPanel(int rows, int columns) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns));

    }

    public List<SlotLabel> getSlotLabels() {
        return ((SlotLabels) this.getComponent(1)).getSlotLabels();   	
    }
}
