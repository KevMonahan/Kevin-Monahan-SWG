/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Products;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ProductsDaoFileImpl implements ProductsDao {

    public static final String PRODUCT_FILE = "products.txt";
    public static final String DELIMITER = ",";

    private Map<String, Products> products = new HashMap<>();

    private void loadProducts() throws FlooringPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(
                    new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load Product data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);
            Products currentProduct = new Products(currentTokens[0]);
            currentProduct.setCostPerSqFt(new BigDecimal(currentTokens[1]));
            currentProduct.setLaborCostPerSqFt(new BigDecimal(currentTokens[2]));

            products.put(currentProduct.getProductType(), currentProduct);
        }

        scanner.close();
    }
    private Products getProduct(String productType) throws FlooringPersistenceException {
        loadProducts();
        return products.get(productType);
    }
}
