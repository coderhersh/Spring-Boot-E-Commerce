package com.ecommerce.ECommerce.Repository;

import com.ecommerce.ECommerce.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String productName);
    Product findByDescription(String productDescription);
    Product findByQuantity(Integer productQuantity);
    Product findByPrice(Float productPrice);

    @Query(
            value = "SELECT * FROM product p WHERE p.price > ?1",
            nativeQuery = true
    )
    List<Product> findByPriceGreaterThanX(Float X);

    @Query(
            value = "SELECT * FROM product p WHERE p.price >= ?1",
            nativeQuery = true
    )
    List<Product> findByPriceGreaterThanEqualToX(Float X);

    @Query(
            value = "SELECT * FROM product p WHERE p.price < ?1",
            nativeQuery = true
    )
    List<Product> findByPriceLesserThanX(Float X);

    @Query(
            value = "SELECT * FROM product p WHERE p.price <= ?1",
            nativeQuery = true
    )
    List<Product> findByPriceLesserThanEqualToX(Float X);

    @Query(
            value = "SELECT * FROM product p WHERE p.price BETWEEN ?1 AND ?2",
            nativeQuery = true
    )
    List<Product> findByPriceBetweenXAndY(Float X, Float Y);

    @Query(
            value = "SELECT * FROM product p ORDER BY p.name",
            nativeQuery = true
    )
    List<Product> sortByNameAscending();

    @Query(
            value = "SELECT * FROM product p ORDER BY p.name DESC",
            nativeQuery = true
    )
    List<Product> sortByNameDescending();

    @Query (
            value = "SELECT * FROM product p ORDER BY p.price",
            nativeQuery = true
    )
    List<Product> sortByPriceAscending();

    @Query (
            value = "SELECT * FROM product p ORDER BY p.price DESC",
            nativeQuery = true
    )
    List<Product> sortByPriceDescending();

    @Query (
            value = "SELECT * FROM product p ORDER BY p.quantity",
            nativeQuery = true
    )
    List<Product> sortByQuantityAscending();

    @Query (
            value = "SELECT * FROM product p ORDER BY p.quantity DESC",
            nativeQuery = true
    )
    List<Product> sortByQuantityDescending();


    @Query (
            value = "SELECT * FROM product p ORDER BY p.created_timestamp",
            nativeQuery = true
    )
    List<Product> sortByAddedDateAscending();

    @Query (
            value = "SELECT * FROM product p ORDER BY p.created_timestamp DESC",
            nativeQuery = true
    )
    List<Product> sortByAddedDateDescending();

    @Query (
            value = "SELECT * FROM product p WHERE p.created_timestamp BETWEEN ?1 AND ?2",
            nativeQuery = true
    )
    List<Product> showByAddedDateBetweenXAndY(LocalDate X, LocalDate Y);

    @Query (
            value = "SELECT * FROM product p ORDER BY p.modified_timestamp",
            nativeQuery = true
    )
    List<Product> sortByModifiedDateAscending();

    @Query (
            value = "SELECT * FROM product p ORDER BY p.modified_timestamp DESC",
            nativeQuery = true
    )
    List<Product> sortByModifiedDateDescending();

    @Query (
            value = "SELECT * FROM product p WHERE p.modified_timestamp BETWEEN ?1 AND ?2",
            nativeQuery = true
    )
    List<Product> showByModifiedDateBetweenXAndY(LocalDate X, LocalDate Y);

    @Query (
            value = "SELECT * FROM product p WHERE p.name LIKE ?1%",
            nativeQuery = true
    )
    List<Product> searchNameOfProductsByCharacters(String characters);

    @Query (
            value = "SELECT * FROM product p WHERE p.description LIKE ?1%",
            nativeQuery = true
    )
    List<Product> searchDescriptionOfProductsByCharacters(String characters);

    @Query(
            value = "DELETE FROM product p WHERE p.name = ?1",
            nativeQuery = true
    )
    void removeByName(String productName);

    @Query(
            value = "DELETE FROM product p WHERE p.description = ?1",
            nativeQuery = true
    )
    void removeByDescription(String productDescription);

    @Query(
            value = "DELETE FROM product p WHERE p.quantity = ?1",
            nativeQuery = true
    )
    void removeByQuantity(Integer productQuantity);

    @Query(
            value = "DELETE FROM product p WHERE p.price = ?1",
            nativeQuery = true
    )
    void removeByPrice(Float productPrice);
}
