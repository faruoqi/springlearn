package com.faruoqi.api.core.product;

public class Product {


    private String id;

    private final int productId;
    private final String name;
    private final int weight;
    private final String serviceAddress;

    public Product(int productId, String name, int weight, String serviceAddress) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.serviceAddress = serviceAddress;
    }

    public Product() {
        this.productId = 0;
        this.name = null;
        this.weight = 0;
        this.serviceAddress = null;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
