package com.ecommerce.ECommerce.Controller;

import com.ecommerce.ECommerce.Entity.Product;
import com.ecommerce.ECommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/get-product-list")
    public ResponseEntity<List<Product>> getProductList() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-product/id/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(value = "/get-product/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @GetMapping(value = "/get-product/description/{description}")
    public Product getProductByDescription(@PathVariable String description) {
        return productService.findByDescription(description);
    }

    @GetMapping(value = "/get-product/quantity/{quantity}")
    public Product getProductByQuantity(@PathVariable Integer quantity) {
        return productService.findByQuantity(quantity);
    }

    @GetMapping(value = "/get-product/price/{price}")
    public Product getProductByPrice(@PathVariable Float price) {
        return productService.findByPrice(price);
    }

    @GetMapping(value = "/sort-by-name-asc")
    List<Product> sortByNameAscending() {
        return productService.sortByNameAscending();
    }

    @GetMapping(value = "/sort-by-name-desc")
    List<Product> sortByNameDescending() {
        return productService.sortByNameDescending();
    }

    @GetMapping(value = "/sort-by-price-asc")
    List<Product> sortByPriceAscending() {
        return productService.sortByPriceAscending();
    }

    @GetMapping(value = "/sort-by-price-desc")
    List<Product> sortByPriceDescending() {
        return productService.sortByPriceDescending();
    }

    @GetMapping(value = "/sort-by-quantity-asc")
    List<Product> sortByQuantityAscending() {
        return productService.sortByQuantityAscending();
    }

    @GetMapping(value = "/sort-by-quantity-desc")
    List<Product> sortByQuantityDescending() {
        return productService.sortByQuantityDescending();
    }

    @GetMapping(value = "/sort-by-added-date-asc")
    List<Product> sortByAddedDateAscending() {
        return productService.sortByAddedDateAscending();
    }

    @GetMapping(value = "/sort-by-added-date-desc")
    List<Product> sortByAddedDateDescending() {
        return productService.sortByAddedDateDescending();
    }

    @GetMapping(value = "/added-date-between/{X}&{Y}")
    List<Product> showByAddedDateBetweenXAndY(@PathVariable("x") LocalDate X, @PathVariable("Y") LocalDate Y) {
        return productService.showByAddedDateBetweenXAndY(X, Y);
    }

    @GetMapping(value = "/sort-by-modified-date-asc")
    List<Product> sortByModifiedDateAscending() {
        return productService.sortByModifiedDateAscending();
    }

    @GetMapping(value = "/sort-by-modified-date-desc")
    List<Product> sortByModifiedDateDescending() {
        return productService.sortByModifiedDateDescending();
    }

    @GetMapping(value = "/modified-date-between/{X}&{Y}")       //  FIX THIS BUG!!!!!!!
    List<Product> showByModifiedDateBetweenXAndY(@PathVariable("X") LocalDate X,@PathVariable("Y") LocalDate Y) {
        return productService.showByAddedDateBetweenXAndY(X, Y);
    }

    @GetMapping(value = "/search-by-name-chars/{characters}")
    List<Product> searchNameOfProductsByCharacters(@PathVariable("characters") String characters) {
        return productService.searchNameOfProductsByCharacters(characters);
    }

    @GetMapping(value = "/search-by-name-description-chars/{characters}")
    List<Product> searchDescriptionOfProductsByCharacters(@PathVariable("characters") String characters) {
        return productService.searchDescriptionOfProductsByCharacters(characters);
    }

    @GetMapping(value = "/get-product-list/{X}&{Y}")
    public List<Product> getProductByPriceRangeBetweenXAndY(@PathVariable("X") Float X, @PathVariable("Y") Float Y) {
        return productService.getProductByPriceRangeBetweenXAndY(X, Y);
    }

    @PostMapping(value = "/add-product")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping(value = "/update-product/id/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping(value = "/delete-product/id/{id}")
    public void removeProductById(@PathVariable Long id) {
        productService.removeById(id);
    }

    @DeleteMapping(value = "/delete-product/name/{name}")
    public void removeProductByName(@PathVariable String name) {
        productService.removeByName(name);
    }

    @DeleteMapping(value = "/delete-product/description/{description}")
    public void removeProductByDescription(@PathVariable String description) {
        productService.removeByDescription(description);
    }

    @DeleteMapping(value = "/delete-product/quantity/{quantity}")
    public void removeProductByQuantity(@PathVariable Integer quantity) {
        productService.removeByQuantity(quantity);
    }

    @DeleteMapping(value = "/delete-product/price/{price}")
    public void removeProductByPrice(@PathVariable Float price) {
        productService.removeByPrice(price);
    }
}
