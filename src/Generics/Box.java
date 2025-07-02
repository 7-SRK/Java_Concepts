package Generics;

public class Box<T> {
    T items;

    public void setItems(T items){
        this.items = items;
    }
    public T getItems(){
        return this.items;
    }
}
