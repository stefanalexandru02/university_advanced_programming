# LAB 5

# Document Management System
Write an application that can manage a catalog of documents. An entry in this catalog might be an article, a book, etc.
A document may be located using a path in the local file system or a link to an external URL. Each document has a unique ID, a name and may have additional tags, which are pairs name-value. Example of tags may be title, author, year, publishingDate, etc.

We have the document class containing details for a document, and a catalog class that represents a collection of documents.
We add more functionality to the catalog class, such as printing out the catalog on the display, saving it to a json file, and creating new catalogs from jsons.