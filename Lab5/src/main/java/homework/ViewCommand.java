package homework;

import compulsory.Catalog;
import homework.exceptions.FileAccessException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Virna Stefan Alexandru
 * Command for viewing the catalog.json file
 */
public class ViewCommand implements Command {
    @Override
    public void executeOperation(Catalog catalog) {
        if(Desktop.isDesktopSupported())
        {
            try{
                Desktop desktop = Desktop.getDesktop();
                File myFile = new File("catalog.json");
                desktop.open(myFile);
            } catch (IOException ex) {
                throw new FileAccessException(ex.getMessage());
            }
        }
    }
}
