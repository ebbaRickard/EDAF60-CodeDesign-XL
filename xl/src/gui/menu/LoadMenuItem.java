package gui.menu;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFileChooser;
import gui.StatusLabel;
import gui.XL;

class LoadMenuItem extends OpenMenuItem {

    private Controller controller;

    public LoadMenuItem(XL xl, StatusLabel statusLabel, Controller controller) {
        super(xl, statusLabel, "Load");
        this.controller = controller;
    }

    protected void action(String path) throws FileNotFoundException {
        XLBufferedReader xlBufferedReader = new XLBufferedReader(path);
        Map <String, String> loadMap = new TreeMap<>();
        xlBufferedReader.load(loadMap);
        controller.loadNewSheet(loadMap);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}
