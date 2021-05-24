//package ru.netology.manager;
//
//import ru.netology.domain.Book;
//import ru.netology.domain.Product;
//import ru.netology.domain.Smartphone;
//
//public class ProductManager {
//
//    private Product[] products;
//    private String text;
//
//
//    public ProductManager(Product[] products) {
//        this.products = products;
//    }
//    public Product[] searchBy(String text) {
//
//    }
//    public boolean matches(Product product, String search) {
//        if (product instanceof Book) { // если в параметре product лежит объект класса Book
//            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
//            if (((Book) product).getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
//                return true;
//            }
//            if (product.getName().contains(search)) {
//                return true;
//            }
//            return false;
//        }
//        if (product instanceof Smartphone) {
//            Smartphone smartphone = (Smartphone) product;
//            if (((Smartphone) product).getProducer().contains(search)) {
//                return true;
//            }
//            if (product.getName().contains(search)) {
//                return true;
//            }
//            return false;
//        }
//
//        return false;
//    }
//}
