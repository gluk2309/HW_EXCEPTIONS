package ru.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestNotFoundException {


    ShopRepository shopRepository = new ShopRepository();
    Product product = new Product(100, "хлеб", 30);
    Product product1 = new Product(5, "торт", 500);
    Product product2 = new Product(70, "сахар", 66);

    @Test
    public void testDeletingNonExistent() {
        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(-100);
        });


    }
    @Test
    public void testFindByIdReturnProduct() {
        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);

        Product expected = product;
        Product actual = shopRepository.findById(100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindByIdReturnNull() {
        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);

        Product expected = null;
        Product actual = shopRepository.findById(200);

        Assertions.assertEquals(expected, actual);
    }
}
