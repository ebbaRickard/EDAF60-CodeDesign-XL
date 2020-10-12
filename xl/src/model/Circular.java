package model;

import expr.Environment;
import util.XLException;

public class Circular implements CellText {

    @Override
    public double value(Environment e) {
        throw new XLException("Circular expression");
    }

    @Override
    public String displayText(Environment e) {
        return null;
    }

}
