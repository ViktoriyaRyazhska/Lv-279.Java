package ua.softserve.academy.linkedlist.module2;

public class Element<T> {
    private T data;
    private Element next;

    public Element(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

//    public void setData(T data) {
//        this.data = data;
//    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element link) {
        this.next = link;
    }

    @Override
    public String toString() {
        return "{" + data + "}";
    }
}
