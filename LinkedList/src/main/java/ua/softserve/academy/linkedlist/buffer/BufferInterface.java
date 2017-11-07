package ua.softserve.academy.linkedlist.buffer;

/*
 * BufferInterface
 *
 * v.1.0
 *
 * 05.11.2017
 *
 * All rights reserved by Team#3
 */
public interface BufferInterface {

    /**
     * Adds element value  in the Buffer.
     *
     * @param value adds in the buffer.
     */
    public void enqueue(Object value);//for adding elements in the Buffer.

    /**
     * Removes the first elements from the Buffer.
     */
    public void dequeue();

    /**
     * Returns the first element added to the Buffer
     *
     * @return first element added to the Buffer.
     */

    public Object peak();

    /**
     * Checks if value exists in the Buffer.
     *
     * @param value
     * @return returns true if value is found in the buffer.
     */

    public boolean contains(Object value);

    /**
     * Returns the number of items in the Buffer.
     *
     * @return int
     */

    public int size();

    /**
     * Checks if Buffer is empty
     *
     * @return return true if Buffer is empty
     */

    public boolean isEmpty();
}
