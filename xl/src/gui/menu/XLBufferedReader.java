package gui.menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;

// TODO move to another package // done?
public class XLBufferedReader extends BufferedReader {

    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate //done?
    public void load(Map<String, String> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                String adress = string.substring(0,i);// TODO
                String value = string.substring(i);
                map.put(adress, value);
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
