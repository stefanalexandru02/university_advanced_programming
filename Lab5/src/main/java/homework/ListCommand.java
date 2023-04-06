package homework;

import compulsory.Catalog;

/**
 * @author Virna Stefan Alexandru
 * Command for listig out catalog
 */
public class ListCommand implements Command {
    @Override
    public void executeOperation(Catalog catalog) {
        System.out.println(catalog);
    }
}
