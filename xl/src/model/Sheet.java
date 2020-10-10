package model;

import java.util.TreeMap;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;
import util.XLException;

import java.io.IOException;
import java.util.Observable;

public class Sheet extends Observable implements Environment {

	private TreeMap<String, CellText> sheet;
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
			System.out.println(e.toString());
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
}
