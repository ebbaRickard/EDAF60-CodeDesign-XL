package model;

import java.util.TreeMap;

import expr.Environment;
import util.XLException;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

public class Sheet extends Observable implements Environment {

    private Map<String, CellText> sheet;
    private CellTextFactory cellTextFactory;

    public Sheet() {
        sheet = new TreeMap<>();
        cellTextFactory = new CellTextFactory();
    }

    public void newInput(String adress, String input) throws IOException {
        if (input.isBlank()) {
            sheet.remove(adress);
            return;
        }
        CellText oldCellText = sheet.get(adress);
        sheet.put(adress, new Circular());
        CellText output = cellTextFactory.build(input);
        try {
            output.value(this);
            sheet.put(adress, output);
        } catch (RuntimeException e) {
            sheet.put(adress, oldCellText);
            throw e;
        }
    }

    public double value(String adress) { // Returnerar det uträknade värdet som ska visas i cellen
        if (sheet.get(adress) != null) {
            CellText cellText = sheet.get(adress);
            return cellText.value(this);
        }
        return 0;
    }

    public String toString(String adress) {

        if (sheet.get(adress) != null) {
            return sheet.get(adress).toString();
        }
        return "";

    }

    public String display(String adress) {
        if (sheet.get(adress) != null) {
            return sheet.get(adress).displayText(this);
        }
        return "";
    }

    public CellText get(String adress) {
        return sheet.get(adress);
    }

    public void clear(String adress) {
        sheet.remove(adress);
    }

    public void clearAll() {
        sheet.clear();
    }

    public Set<Entry<String, CellText>> entrySet() {
        return sheet.entrySet();
    }
}
