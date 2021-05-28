package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String producer;

    public Smartphone () {
        super();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone smartphone = (Smartphone) o;
        return Objects.equals(producer, smartphone.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), producer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + super.getId() + ", " +
                "name=" + super.getName() + ", " +
                "price=" + super.getPrice() + ", " +
                "author=" + producer +
                '}';
    }
}
