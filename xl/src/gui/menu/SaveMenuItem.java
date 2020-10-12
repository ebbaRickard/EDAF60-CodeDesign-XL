package gui.menu;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import gui.StatusLabel;
import gui.XL;

class SaveMenuItem extends OpenMenuItem {
	
	private Controller controller;

    public SaveMenuItem(XL xl, StatusLabel statusLabel, Controller controller) {
        super(xl, statusLabel, "Save");
        this.controller = controller;
    }

    protected void action(String path) throws FileNotFoundException {
    	XLPrintStream xlPrintStream = new XLPrintStream(path);
    	xlPrintStream.save(controller.save());
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
        
    }
}
