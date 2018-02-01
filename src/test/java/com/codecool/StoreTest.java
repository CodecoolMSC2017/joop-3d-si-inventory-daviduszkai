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
        boolean isHasIt = false;
        myPersistent.storeCDProduct("Fekete vonat", 100, 8);
        for (int i = 0; i < myPersistent.getProducts().size(); i++) {
            if (myPersistent.getAllProduct().get(i).getName().equals("Fekete vonat")) {
                isHasIt = true;
            }
        }
        assertTrue(isHasIt);
    }

    @Test
    void storeBookProduct() {

        boolean isHasIt = false;
        myPersistent.storeBookProduct("An Idiot Abroad",2500,220);
        for (int i = 0; i < myPersistent.getProducts().size(); i++) {
            if (myPersistent.getAllProduct().get(i).getName().equals("An Idiot Abroad")) {
                isHasIt = true;
            }
        }
        assertTrue(isHasIt);
    }

    @Test
    void storeProduct() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void loadProducts() {
        boolean isItHasMore = false;
        int normalSize = myPersistent.getProducts().size();
        myPersistent.loadProducts();
        if (myPersistent.getProducts().size() > normalSize) {
            isItHasMore = true;
        }
        assertTrue(isItHasMore);
    }

    @Test
    void store() {
    }
}