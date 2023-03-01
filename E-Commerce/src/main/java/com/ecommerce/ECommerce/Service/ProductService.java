package com.ecommerce.ECommerce.Service;

import com.ecommerce.ECommerce.Entity.Product;
import com.ecommerce.ECommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product findByName(String productName) {
        return productRepository.findByName(productName);
    }

    public Product findByDescription(String productDescription) {
        return productRepository.findByDescription(productDescription);
    }

    public Product findByQuantity(Integer productQuantity) {
        return productRepository.findByQuantity(productQuantity);
    }

    public Product findByPrice(Float productPrice) {
        return productRepository.findByPrice(productPrice);
    }

    public List<Product> findByPriceGreaterThanX(Float X) {
        return productRepository.findByPriceGreaterThanX(X);
    }

    public List<Product> findByPriceGreaterThanEqualToX(Float X) {
        return productRepository.findByPriceGreaterThanX(X);
    }

    public List<Product> findByPriceLesserThanX(Float X) {
        return productRepository.findByPriceLesserThanX(X);
    }

    public List<Product> findByPriceLesserThanEqualToX(Float X) {
        return findByPriceGreaterThanEqualToX(X);
    }

    public List<Product> sortByNameAscending() {
        return productRepository.sortByNameAscending();
    }

    public List<Product> sortByNameDescending() {
        return productRepository.sortByNameDescending();
    }

    public List<Product> sortByPriceAscending() {
        return productRepository.sortByPriceAscending();
    }

    public List<Product> sortByPriceDescending() {
        return productRepository.sortByPriceDescending();
    }

    public List<Product> sortByQuantityAscending() {
        return productRepository.sortByQuantityAscending();
    }

    public List<Product> sortByQuantityDescending() {
        return productRepository.sortByQuantityDescending();
    }

    public List<Product> sortByAddedDateAscending() {
        return productRepository.sortByAddedDateAscending();
    }

    public List<Product> sortByAddedDateDescending() {
        return productRepository.sortByAddedDateDescending();
    }

    public List<Product> showByAddedDateBetweenXAndY(LocalDate X, LocalDate Y) {
        return productRepository.showByAddedDateBetweenXAndY(X, Y);
    }

    public List<Product> sortByModifiedDateAscending() {
        return productRepository.sortByModifiedDateAscending();
    }

    public List<Product> sortByModifiedDateDescending() {
        return productRepository.sortByAddedDateDescending();
    }

    public List<Product> showByModifiedDateBetweenXAndY(LocalDate X, LocalDate Y) {
        return productRepository.showByModifiedDateBetweenXAndY(X, Y);
    }

    public List<Product> searchNameOfProductsByCharacters(String characters) {
        return productRepository.searchNameOfProductsByCharacters(characters);
    }

    public List<Product> searchDescriptionOfProductsByCharacters(String characters) {
        return productRepository.searchDescriptionOfProductsByCharacters(characters);
    }

    public List<Product> getProductByPriceRangeBetweenXAndY(Float X, Float Y) {
        return productRepository.findByPriceBetweenXAndY(X, Y);
    }

    public void updateProduct(Long id, Product product) {
        productRepository.findById(id)
                .map(product1 -> {
                    product1.setName(product.getName());
                    product1.setDescription(product.getDescription());
                    product1.setQuantity(product.getQuantity());
                    product1.setPrice(product.getPrice());
                    return productRepository.save(product);
                })
                .orElseGet(
                        () -> {
                            return productRepository.save(product);
                        }
                );
    }

    public void removeById(Long id) {
        productRepository.deleteById(id);
    }

    public void removeByName(String productName) {
        productRepository.removeByName(productName);
    }

    public void removeByDescription(String productDescription) {
        productRepository.removeByDescription(productDescription);
    }

    public void removeByQuantity(Integer productQuantity) {
        productRepository.removeByQuantity(productQuantity);
    }

    public void removeByPrice(Float productPrice) {
        productRepository.removeByPrice(productPrice);
    }
}
