package gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import model.Sheet;

public class XLMenuBar extends JMenuBar {
	

    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Controller controller) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel));
        file.add(new LoadMenuItem(xl, statusLabel));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(controller));
        edit.add(new ClearAllMenuItem(controller));
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
    
}
