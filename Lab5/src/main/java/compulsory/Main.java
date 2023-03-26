package compulsory;

import java.io.IOException;
import java.util.Hashtable;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        CatalogUtils utils = new CatalogUtils();

        catalog.add(new Document("1", "Test doc 1", "/doc.pdf", DocumentType.Document, new Hashtable<>(){{ put("autor", "Stefan");}}));
        catalog.add(new Document("2", "Test doc 2", "/doc.pdf", DocumentType.Article, null));
        catalog.add(new Document("3", "Test doc 3", "/doc.pdf", DocumentType.Magazine, null));
        catalog.add(new Document("3", "Test doc 4", "/doc.pdf", DocumentType.Magazine, null));

        //System.out.println(catalog);
        System.out.println(utils.toString(catalog));

        try {
            //catalog.save("catalog.json");
            utils.save(catalog, "catalog.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            //Catalog newCatalog = Catalog.load("catalog.json");
            Catalog newCatalog = utils.load("catalog.json");
            System.out.println("Imported catalog");
            System.out.println(newCatalog);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
