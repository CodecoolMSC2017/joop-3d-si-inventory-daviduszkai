package com.codecool;

public class Main {
    public static void main(String[] args) {
        PersistentStore ps = new PersistentStore();
        StoreManager storage = new StoreManager();
        storage.addStorage(ps);
        storage.addCDProduct("Romantic",200,10);
        storage.addBookProduct("Pisti's beautiful life", 2500, 500);

        //ps.loadProducts();
        System.out.println(storage.listProducts());
        System.out.println(storage.getTotalProductPrice());
    }
}
