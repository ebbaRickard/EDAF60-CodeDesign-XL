package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private Controller controller;

    public ClearMenuItem(Controller controller) {
        super("Clear");
        this.controller = controller;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        controller.clearMarked();
    }
}
