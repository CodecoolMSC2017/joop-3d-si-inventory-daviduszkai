package com.codecool;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //PersistentStore myPersistent = new PersistentStore();
        PersistentCsvStore myCSvStore = new PersistentCsvStore();
        StoreManager myStorage = new StoreManager();
        //myStorage.addStorage(myPersistent);
        myStorage.addStorage(myCSvStore);

        myStorage.addCDProduct("Romantic",200,10);
        myStorage.addBookProduct("Pisti's beautiful life", 2500, 500);

        myCSvStore.storeCsv();

        //myPersistent.store("Products.xml");
        //myPersistent.loadProducts("Products.xml");
        //System.out.println(myStorage.listProducts());
        //System.out.println(myStorage.getTotalProductPrice());
    }
}
