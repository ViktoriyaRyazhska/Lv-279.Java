package ua.softserve.academy.linkedlist.deque;

public interface Deque<T> {

    boolean isEmpty();

    int size();

    boolean contains(T value);

    T PeakLast();

   T PeakFirst();

   T DequeueLast();

    T DequeueFirst();

  void   EnqueueLast(T value);

   void EnqueueFirst(T value);
}
