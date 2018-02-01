package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    PersistentStore myPersistent;
    CDProduct cd;
    BookProduct book;
    List<Product> testListOfProducts;

    @BeforeEach
    void setUp() {
        myPersistent = new PersistentStore();
        testListOfProducts = myPersistent.loadProducts();
    }

    @Test
    void getAllProduct() {
        assertEquals(myPersistent.getAllProduct().size(), myPersistent.getProducts().size());
    }

    @Test
    void storeCDProduct() {

    }

    @Test
    void storeBookProduct() {

    }

    @Test
    void storeProduct() {
    }

    @Test
    void createProduct() {

    }

    @Test
    void loadProducts() {

    }

    @Test
    void store() {
        
    }
}