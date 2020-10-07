package model;

import expr.Environment;

public class Comment implements CellText {

	private double value;
	private String name;

	public Comment(String comment) {

	}

	public String toString() {
		return "";
	}

	@Override
	public double value(Environment e) {
		return 0;
	}

}
