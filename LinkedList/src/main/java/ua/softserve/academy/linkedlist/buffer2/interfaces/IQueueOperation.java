/*
* QueueForBuffer
*
* Version 1.0-SNAPSHOT
*
* 05.11.17
*
* All rights reserved by Team#3
* */

package jar.interfaces;

import java.util.Iterator;

public interface IQueueOperation<T> extends Iterator<T> {
    void enqueue(T val);
    void dequeue();
    T peak();
    boolean contains(T val);
    int size();
    boolean isEmpty();

}
