package model;

import expr.Environment;

public class Comment implements CellText {

	private String comment;

	public Comment(String comment) {
		this.comment = comment;
	}

	public String toString() {
		return comment;
	}
	
	

	@Override
	public double value(Environment e) {
		return 0;
	}

	@Override
	public String displayText(Environment e) {
		return comment.substring(1);
	}

}
