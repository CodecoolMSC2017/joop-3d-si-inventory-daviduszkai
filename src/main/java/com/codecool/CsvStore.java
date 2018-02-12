package com.codecool;


import java.io.BufferedWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class CsvStore implements StorageCapable {
    private List listOfProducts = new ArrayList<>();


    @Override
    public List<Product> getAllProduct() {
        return listOfProducts;

    }
    @Override
    public void storeCDProduct(String name, int price, int tracks) {
        storeProduct(createProduct("cd", name, price, tracks));
    }

    @Override
    public void storeBookProduct(String name, int price, int pages) {
        storeProduct(createProduct("book", name, price, pages));
    }
    protected abstract void storeProduct(Product product);

    protected Product createProduct (String type, String name,int price, int size){

        Product product = null;

        try {
            if (type.toLowerCase().equals("book")) {
                product = new BookProduct(name, price, size);
            } else if (type.toLowerCase().equals("cd")) {
                product = new CDProduct(name, price, size);
            }

        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            System.out.println("Not valid type! (Try cd or book!)");
        }
        return product;
    }
    public String[] decompCd(CDProduct product){
        String attrib[] = new String[3];
        attrib[0] = product.getName();
        attrib[1] = Integer.toString(product.getPrice());
        attrib[2] = Integer.toString(product.getNumOfTracks());
        return attrib;
    }
    public String[] decompBook(BookProduct product){
        String attrib[] = new String[3];
        attrib[0] = product.getName();
        attrib[1] = Integer.toString(product.getPrice());
        attrib[2] = Integer.toString(product.getNumOfPages());
        return attrib;
    }

    public void writeToCsv(){
        String[] attributes = null;
        if(listOfProducts.size()!=0){
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/data/product.csv"));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < listOfProducts.size() ; i++) {
                    if(listOfProducts.get(i) instanceof CDProduct){
                        CDProduct cd = (CDProduct) listOfProducts.get(i);
                        int collCnt = 0;
                        attributes = decompCd(cd);
                        for(String att : attributes){
                            sb.append(att);
                            collCnt++;
                            if(collCnt != 3){
                                sb.append(",");
                            }
                        }
                        sb.append("\n");
                    }else{
                        BookProduct book = (BookProduct) listOfProducts.get(i);
                        int collCnt = 0;
                        attributes = decompBook(book);
                        for(String att : attributes){
                            sb.append(att);
                            collCnt++;
                            if(collCnt != 3){
                                sb.append(",");
                            }
                        }
                        sb.append("\n");
                    }

                }
                String mystr = sb.toString();
                if (mystr.length() != 0) {
                    mystr = mystr.substring(0, mystr.length() - 1);
                }
                bw.write(mystr);
                bw.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    public void storeCsv() {
        writeToCsv();
    }
}
