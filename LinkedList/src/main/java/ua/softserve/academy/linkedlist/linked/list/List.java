package ua.softserve.academy.linkedlist.linked.list;

public interface List<T> {
    void add(T elem);
    boolean remove(T value);
    int size();
    boolean contains(T value);
    void clear();
}