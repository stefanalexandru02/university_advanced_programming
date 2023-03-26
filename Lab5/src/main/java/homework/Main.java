package homework;

import compulsory.Catalog;
import compulsory.CatalogUtils;
import compulsory.Document;
import compulsory.DocumentType;

import java.io.IOException;
import java.util.Hashtable;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        new LoadCommand().executeOperation(catalog);
        new ListCommand().executeOperation(catalog);

        //new ViewCommand().executeOperation(catalog);

        new ReportCommand().executeOperation(catalog);
    }
}
