package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "Fight Club", 700, "C. Palahniuk");
    private Product second = new Smartphone(2, "Samsung A7", 20000, "Samsung Corp.");
    private Product third = new Book(3, "1984", 400, "G. Orwell");
    private Product fourth = new Smartphone(4, "Iphone 10", 50000, "Apple");
    private Product fifth = new Book(5, "Newton's Apple", 400, "G. Orwell");
    private Product sixth = new Smartphone(6, "Coral Phone", 60000, "Windows");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldAddOneMore() {
        manager.add(sixth);

        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchNothingComparable(){
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Nothing");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByName() {
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Fight Club");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("G. Orwell");
        Product[] expected = new Product[]{third, fifth};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByAnyWord() {
        Product[] expected = new Product[]{fourth, fifth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByProducer() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Samsung Corp.");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("Iphone 10");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOtherProducer() {
        manager.add(sixth);
        Product[] actual = manager.searchBy("Windows");
        Product[] expected = new Product[]{sixth};
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldSearchNoName() {
//        Product[] expected = new Product[]{};
//        Product[] actual = manager.searchBy();
//        assertArrayEquals(expected, actual);
//    }


}