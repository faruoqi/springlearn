package com.faruoqi.microservices.core.product.service;

import com.faruoqi.api.core.product.Product;
import com.faruoqi.api.core.product.ProductService;
import com.faruoqi.api.exceptions.InvalidInputException;
import com.faruoqi.api.exceptions.NotFoundException;
import com.faruoqi.util.http.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements ProductService {

    private final ServiceUtil serviceUtil;
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Autowired
    public ProductServiceImpl(ServiceUtil serviceUtil){
        this.serviceUtil = serviceUtil;
    }

    public Product getProduct(int productId){

        LOG.debug("/product return the found product for productId={}", productId);

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 13) {
            throw new NotFoundException("No product found for productId: " + productId);
        }

        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }
}
