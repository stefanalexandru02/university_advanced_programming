package compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Catalog implements Serializable {
    private List<Document> documentsList = new ArrayList<>();

    public List<Document> getDocumentsList() {
        return documentsList;
    }

    public void setDocumentsList(List<Document> documentsList) {
        this.documentsList = documentsList;
    }

    /**
     * Add document on catalog
     * @param document
     */
    public void add(Document document) {
        documentsList.add(document);
    }

    /**
     * Save catalog to file
     * @param path
     * @throws IOException
     */
    public void save(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), this);
    }

    /**
     * @param path
     * @return Catalog instance based on json file
     * @throws IOException
     */
    public static Catalog load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Catalog.class);
    }

    /**
     * @return String representing a catalog
     */
    @Override
    public String toString() {
        return "Catalog{" +
                "documentsList=" + documentsList +
                '}';
    }
}
