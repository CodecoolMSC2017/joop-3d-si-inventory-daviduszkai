package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvStoreTest {
    PersistentCsvStore myPersistent;
    @BeforeEach
    void setUp() {
        myPersistent = new PersistentCsvStore();
        myPersistent.storeCDProduct("Amokfutok",200,10);
        myPersistent.storeBookProduct("kozso's life",1000,200);
    }

    @Test
    void getAllProduct() {
        assertEquals(2,myPersistent.getAllProduct().size());
    }

    @Test
    void storeCDProduct() {
        assertEquals("Amokfutok",myPersistent.getAllProduct().get(0).getName());
    }

    @Test
    void storeBookProduct() {
        assertEquals("kozso's life",myPersistent.getAllProduct().get(1).getName());
    }


}