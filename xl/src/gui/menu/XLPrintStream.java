package gui.menu;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.Set;

import model.CellText;

// TODO move to another package
public class XLPrintStream extends PrintStream {

    public XLPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    // TODO Change Object to something appropriate
    public void save(Set<Entry<String, CellText>> set) {
        for (Entry<String, CellText> entry : set) {
            print(entry.getKey());
            print('=');
            println(entry.getValue().toString());
        }
        flush();
        close();
    }
}
