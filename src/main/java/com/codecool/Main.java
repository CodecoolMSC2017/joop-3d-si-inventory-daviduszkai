package com.codecool;

public class Main {
    public static void main(String[] args) {
        PersistentStore ps = new PersistentStore();
        StoreManager storage = new StoreManager();
        storage.addStorage(ps);
        storage.addBookProduct("Mama", 2500, 500);
        storage.addBookProduct("Papa", 2500, 500);

        //ps.loadProducts();
        System.out.println(storage.listProducts());
        System.out.println(storage.getTotalProductPrice());
    }
}
