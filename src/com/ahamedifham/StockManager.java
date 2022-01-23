package com.ahamedifham;

public class StockManager {

    private ExternalISBNDataService webService;

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }

    private ExternalISBNDataService databaseService;

    public String getLocatorCode(String isbn) {
        Book book = databaseService.lookup(isbn);
        if(book == null){
            book = webService.lookup(isbn);
        }
        StringBuilder locator = new StringBuilder();
        locator.append(isbn.substring(isbn.length()-4));
        locator.append(book.getAuthor().substring(0,1));
        locator.append(String.valueOf(book.getTitle().split(" ").length));
        return locator.toString();
    }

    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }
}
