package ru.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestNotFoundException {


    ShopRepository shopRepository = new ShopRepository();
    Product product1 = new Product(100, "хлеб", 30);
    Product product2 = new Product(5, "торт", 500);
    Product product3 = new Product(70, "сахар", 66);


    @Test
    public void testRemoveByIdProductRemoval() {
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.removeById(70);

        Product[] expected = {product1, product2};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDeletingNonExistent() {
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(200);
        });


    }


}
