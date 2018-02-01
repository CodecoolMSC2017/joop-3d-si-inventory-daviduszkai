package com.codecool;

public class Main {
    public static void main(String[] args) {
        PersistentStore myPersistent = new PersistentStore();
        StoreManager myStorage = new StoreManager();
        myStorage.addStorage(myPersistent);
        myStorage.addCDProduct("Romantic",200,10);
        myStorage.addBookProduct("Pisti's beautiful life", 2500, 500);

        myPersistent.loadProducts();
        System.out.println(myStorage.listProducts());
        System.out.println(myStorage.getTotalProductPrice());
    }
}
