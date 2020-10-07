package model;

import java.io.IOException;

import expr.ExprParser;

public class CellTextFactory {

	private ExprParser exprParser;

	public CellTextFactory() {
		exprParser = new ExprParser();
	}

	public CellText build(String input) throws IOException {
		if (input.charAt(0)== '#') {
			return new Comment(input);
		}
		return exprParser.build(input);
	}

}
