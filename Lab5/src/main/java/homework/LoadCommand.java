package homework;

import compulsory.Catalog;
import homework.exceptions.FileAccessException;
import homework.exceptions.GenericCustomException;

import java.io.IOException;

/**
 * @author Virna Stefan Alexandru
 * Command for loading catalog
 */
public class LoadCommand implements Command {
    @Override
    public void executeOperation(Catalog catalog) {
        try {
            Catalog copy = Catalog.load("catalog.json");
            copy.getDocumentsList().forEach(document -> {
                catalog.getDocumentsList().add(document);
            });
        }
        catch (IOException ex) {
            throw new FileAccessException(ex.getMessage());
        }
        catch (Exception ex) {
            throw new GenericCustomException(ex.getMessage());
        }
    }
}
