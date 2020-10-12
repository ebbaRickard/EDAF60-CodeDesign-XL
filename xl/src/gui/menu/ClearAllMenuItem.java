package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import model.Sheet;


class ClearAllMenuItem extends JMenuItem implements ActionListener {
    private Controller controller;

    public ClearAllMenuItem(Controller controller) {
        super("Clear all");
        this.controller =  controller;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        controller.clearAll();
    }


}
