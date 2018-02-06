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
        testListOfProducts = myPersistent.loadProducts("TestStore.xml");
        myPersistent.storeCDProduct("Pista",200,10);
        myPersistent.storeBookProduct("Kokero's life",1000,200);
    }

    @Test
    void getAllProduct() {
        assertEquals(74,myPersistent.getAllProduct().size());
    }

    @Test
    void storeCDProduct() {
        assertEquals("Romantic",myPersistent.getAllProduct().get(0).getName());

    }

    @Test
    void storeBookProduct() {
        assertEquals("Kokero's life",myPersistent.getAllProduct().get(3).getName());
    }

    @Test
    void loadProducts() {
        List<Product> loadTest = myPersistent.loadProducts("TestStore.xml");
        assertEquals(146,loadTest.size());
    }

}