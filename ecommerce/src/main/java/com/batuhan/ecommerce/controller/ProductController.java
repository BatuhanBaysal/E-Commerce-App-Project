package com.batuhan.ecommerce.controller;

import com.batuhan.ecommerce.model.BrandResponse;
import com.batuhan.ecommerce.model.ProductResponse;
import com.batuhan.ecommerce.model.TypeResponse;
import com.batuhan.ecommerce.service.BrandService;
import com.batuhan.ecommerce.service.ProductService;
import com.batuhan.ecommerce.service.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final BrandService brandService;
    private final TypeService typeService;

    public ProductController(ProductService productService, BrandService brandService, TypeService typeService) {
        this.productService = productService;
        this.brandService = brandService;
        this.typeService = typeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id")Integer productId) {
        ProductResponse productById = productService.getProductById(productId);
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<ProductResponse> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("brands")
    public ResponseEntity<List<BrandResponse>> getBrands() {
        List<BrandResponse> allBrands = brandService.getAllBrands();
        return new ResponseEntity<>(allBrands, HttpStatus.OK);
    }

    @GetMapping("types")
    public ResponseEntity<List<TypeResponse>> getTypes() {
        List<TypeResponse> allTypes = typeService.getAllTypes();
        return new ResponseEntity<>(allTypes, HttpStatus.OK);
    }
}