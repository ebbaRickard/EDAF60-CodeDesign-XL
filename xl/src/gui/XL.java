package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;


import model.Sheet;
import gui.menu.Controller;
import gui.menu.XLMenuBar;
import model.Sheet;

import java.io.IOException;

public class XL extends JFrame implements Printable {

    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private StatusLabel statusLabel = new StatusLabel();
    private XLList xlList;
    private Controller controller;
    private Sheet sheet;

    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter);
    }

    public XL(XLList xlList, XLCounter counter) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        sheet = new Sheet();

        xlList.add(this);
        counter.increment();
        StatusPanel statusPanel = new StatusPanel(statusLabel);
        SheetPanel sheetPanel = new SheetPanel(ROWS, COLUMNS);
        Editor editor = new Editor();
        controller = new Controller(sheet, statusPanel, sheetPanel, editor);

        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);

        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, controller));

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page > 0)
            return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(g2d);
        return PAGE_EXISTS;
    }

    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    public static void main(String[] args) {
        new XL(new XLList(), new XLCounter());

    }


}
