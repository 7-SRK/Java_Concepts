package Generics;

public class Product<T, U> {
    T items;
    U price;

    Product(T items,U price){
        this.items = items;
        this.price = price;
    }

    public T getItems() {
        return items;
    }

    public U getPrice() {
        return price;
    }
}
