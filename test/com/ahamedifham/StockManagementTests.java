package com.ahamedifham;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StockManagementTests {

    @Test
    public void testCanGetACorrectLocatorCode() {
        ExternalISBNDataService testService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice and Men", "J K");
            }
        };

        ExternalISBNDataService testDatabaseService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return null;
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setWebService(testService);
        stockManager.setDatabaseService(testDatabaseService);
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent(){
        fail();
    }

    @Test
    public void webServiceIsUsedIfNotPresentInDatabase(){
        fail();
    }
}
