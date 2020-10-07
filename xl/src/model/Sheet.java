package model;

import java.util.TreeMap;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;

import java.io.IOException;
import java.util.Observable;

public class Sheet extends Observable implements Environment {

	private TreeMap<String, Expr> sheet;
	private ExprParser exprParser;

	public Sheet() {
		sheet = new TreeMap<>();
		exprParser = new ExprParser();
	}

	public void newInput(String adress, String input) throws IOException {
		sheet.put(adress, exprParser.build(input));
	}

	public double value(String adress) { // Returnerar det uträknade värdet som ska visas i cellen
		Expr expr = sheet.get(adress);
		return expr.value(this);
	}

	public void writeCell(String text, Expr expression) {

		notifyObservers();
	}

	public Expr get(String adress) {
		return sheet.get(adress);
	}

	private double Calculate() { // ?? Finns inte denna egentligen i get()-metoden
		return 0;
	}
}
