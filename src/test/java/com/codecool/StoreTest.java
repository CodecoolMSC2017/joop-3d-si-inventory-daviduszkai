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
        assertEquals(myPersistent.getAllProduct().size(), 74);
    }

    @Test
    void storeCDProduct() {
        assertEquals(myPersistent.getAllProduct().get(0).getName(),"Romantic");

    }

    @Test
    void storeBookProduct() {
        assertEquals(myPersistent.getAllProduct().get(3).getName(),"Kokero's life");
    }

    @Test
    void loadProducts() {
        List<Product> loadTest = myPersistent.loadProducts("TestStore.xml");
        assertEquals(loadTest.size(), 146);
    }

    @Test
    void store() {

    }
}