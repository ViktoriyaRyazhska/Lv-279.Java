package ua.softserve.academy.linkedlist.linked.list;

public class Node<T> {

    private Node<T> previous;
    private T value;
    private Node<T> next;

    public boolean isSingle() {
        return isFirst() && isLast();
    }

    public boolean isFirst() {
        return previous == null;
    }

    public boolean isLast() {
        return next == null;
    }

    public Node(Node<T> previous, T value, Node<T> next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void deleteNextLink(){
       getNext().setPrevious(getPrevious());;
    }

    public void deletePreviousLink(){
        getPrevious().setNext(this.getNext());
    }
}
