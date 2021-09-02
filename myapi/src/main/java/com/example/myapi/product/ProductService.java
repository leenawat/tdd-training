package com.example.myapi.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public ProductResponse getProductDetail(int id) {
        Product product = productRepository.getById(id);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProductName(product.getName());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

}
