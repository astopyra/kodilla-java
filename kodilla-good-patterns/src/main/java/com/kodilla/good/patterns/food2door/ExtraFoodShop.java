package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ExtraFoodShop implements Producer{

    private String name = "Extra Food Shop";
    private List<Product> products = new ArrayList<>(Arrays.asList(new Product("Chicken with rice", 10),
            new Product("Steamed vegetables", 10)));


    @Override
    public boolean process() {
        boolean orderCompleted;
        Product product = selectProduct();

        if(products.contains(product)){
            System.out.println("Preparing food");
            System.out.println("Sending courier");
            orderCompleted = true;
        }else {
            orderCompleted = false;
            System.out.println("Order can not be carried out.");
        }
        return orderCompleted;
    }

    //losowy wybor produktu
    public Product selectProduct(){
        Random rand = new Random();
        return products.get(rand.nextInt(2));
    }

    @Override
    public void getInfoAboutProducer() {
        System.out.println(name + "\nList of products:");
        for(Product product : products){
            System.out.println(product.getName() + "  quantity: " + product.getQuantity());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
