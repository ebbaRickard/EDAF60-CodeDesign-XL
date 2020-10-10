package model;

import expr.Environment;

public interface CellText {
	
	public double value(Environment e);
	public String displayText(Environment e);

}
