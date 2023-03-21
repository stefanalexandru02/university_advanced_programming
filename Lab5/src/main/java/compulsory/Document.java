package compulsory;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Map;

/**
 * @author Virna Stefan Alexandru
 */
public class Document implements Serializable {
    private String Id;
    private String Name;
    private String Location;
    private DocumentType DocumentType;
    private Map<String, String> Tags;

    /**
     * Create new instance of a document
     * @param id
     * @param name
     * @param location
     * @param documentType
     * @param tags
     */
    public Document(String id, String name, String location, compulsory.DocumentType documentType, Map<String, String> tags) {
        Id = id;
        Name = name;
        Location = location;
        DocumentType = documentType;
        Tags = tags;
    }

    /**
     * Creates empty instance of document
     */
    public Document() { }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public compulsory.DocumentType getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(compulsory.DocumentType documentType) {
        DocumentType = documentType;
    }

    public Map<String, String> getTags() {
        return Tags;
    }

    public void setTags(Map<String, String> tags) {
        Tags = tags;
    }

    /**
     * @return String representing the document
     */
    @Override
    public String toString() {
        return "\n\tDocument{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", DocumentType=" + DocumentType +
                ", Tags=" + Tags +
                '}';
    }
}
