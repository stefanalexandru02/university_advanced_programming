package compulsory;

import java.io.IOException;

/**
 * @author Virna Stefan Alexandru
 */
public class CatalogUtils {
    /**
     * @param catalog
     * @return A String representing a catalog
     */
    public String toString(Catalog catalog) { return catalog.toString(); }

    /**
     * Helper to add a document to a catalog
     * @param catalog
     * @param document
     */
    public void add(Catalog catalog, Document document) { catalog.add(document); }

    /**
     * Saves a catalog to a json file
     * @param catalog
     * @param path
     * @throws IOException
     */
    public void save(Catalog catalog, String path) throws IOException { catalog.save(path); }

    /**
     * Loads a json file and returns a catalog object
     * @param path
     * @return
     * @throws IOException
     */
    public Catalog load(String path) throws IOException { return Catalog.load(path); }
}
