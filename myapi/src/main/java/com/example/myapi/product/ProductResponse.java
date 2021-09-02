package com.example.myapi.product;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("price")
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, productName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductResponse other = (ProductResponse) obj;
        return Objects.equals(id, other.id) && Objects.equals(price, other.price)
                && Objects.equals(productName, other.productName);
    }

}
