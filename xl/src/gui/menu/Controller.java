package gui.menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import gui.*;
import model.CellText;
import model.Sheet;
import util.XLException;
public class Controller {

    private Sheet sheet;
    private SlotLabel markedLabel;
    private CurrentLabel currentLabel;
    private SheetPanel sheetPanel;
    private Editor editor;
    private StatusLabel statusLabel;


    public Controller(Sheet sheet, StatusPanel statusPanel, SheetPanel sheetPanel, Editor editor) {
        this.sheet = sheet;
        this.sheetPanel = sheetPanel;
        this.editor = editor;

        for (SlotLabel s:sheetPanel.getSlotLabels()) {
            s.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    updateCurrentLabel(s);	
                }
            });
        }
        this.statusLabel = statusPanel.getStatusLabel();
        this.currentLabel = statusPanel.getCurrentLabel();
        updateCurrentLabel(sheetPanel.getSlotLabels().get(0));

        editor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = editor.getText();
                updateModel(s);
            }
        });

    }

    private void updateCurrentLabel(SlotLabel slotLabel) {

        if (markedLabel != null) {
            markedLabel.setBackground(Color.WHITE);
        }
        markedLabel = slotLabel;
        markedLabel.setBackground(Color.YELLOW);
        currentLabel.setText(markedLabel.getAdress());
        editor.setText(sheet.toString(markedLabel.getAdress())); //get raw expression
    }

    private void updateModel(String s) {
        try {
            sheet.newInput(markedLabel.getAdress(), s);
            updateView();
            statusLabel.setText("");
        }
        catch (IOException e){

        }catch(XLException f) {
            statusLabel.setText(f.toString());

        }

    }

    private void updateView() {

        for (SlotLabel s:sheetPanel.getSlotLabels()) {
            s.setText(sheet.display(s.getAdress()));
        }

    }
    
    public void clearAll() {
        sheet.clearAll();
        updateView();
    }
    
    public void clearMarked() {
        sheet.clear(markedLabel.getAdress());
        updateView();
    }

    public Set<Entry<String, CellText>> save() {
        return sheet.entrySet();

    }
    
    public void loadNewSheet(Map <String, String> loadMap) {
        sheet.clearAll();
        try {
            for(Entry<String, String> e: loadMap.entrySet()) {

                sheet.newInput(e.getKey(), e.getValue());

            }
        } catch (IOException e1) {
            // TODO Auto-generated catch blocks
            e1.printStackTrace();
        } catch (XLException e2) {
            statusLabel.setText(e2.toString());
        }
        updateView();
        editor.setText(sheet.toString(markedLabel.getAdress()));
    }
}
