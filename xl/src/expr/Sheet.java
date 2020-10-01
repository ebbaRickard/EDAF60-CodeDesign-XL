package expr;

import java.util.TreeMap;
import java.util.Observable;

public class Sheet extends Observable implements Environment {

	private TreeMap<String, Expr> sheet;
	
	public Sheet() {
		sheet = new TreeMap<>(); 
	}

	public double value(String name) {
		return 0;
	}

	public void writeCell(String text, Expr expression) {

	}

	public Expr get(String text) {
		return null;
	}

	private double Calculate() { // ??
		return 0;
	}
}
