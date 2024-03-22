package com.royalenfield.dataaggregator.DataPreserveLayer;

import java.util.Arrays;
import java.util.Iterator;

/**
 * CircularBuffer is a generic data structure representing a circular buffer.
 * It provides methods for adding elements, accessing elements by index,
 * retrieving the size of the buffer, and clearing its contents.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
public class CircularBuffer<T> implements Iterable<T> {
    private Object[] buffer;
    private int size;
    private int head;
    private int tail;
    private int count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new Object[size];
        head = 0;
        tail = 0;
        count = 0;
    }

    /**
     * Adds an element to the circular buffer. If the buffer is full, the oldest element is replaced.
     *
     * @param element The element to be added to the circular buffer.
     */
    public void add(T element) {
        if (count == size) {
            head = (head + 1) % size;
            count--;
        }
        buffer[tail] = element;
        tail = (tail + 1) % size;
        count++;
    }

    /**
     * Retrieves the element at the specified index from the circular buffer.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) buffer[(head + index) % size];
    }

    public int size() {
        return count;
    }

    public void clear() {
        Arrays.fill(buffer, null);
        head = tail = count = 0;
    }


    /**
     * Returns an iterator over the elements in the circular buffer.
     * The iterator starts at the head of the buffer and iterates through the elements in the buffer.
     *
     * @return An iterator over the elements in the circular buffer.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = head;
            private int remaining = count;

            @Override
            public boolean hasNext() {
                return remaining > 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                T element = (T) buffer[currentIndex];
                currentIndex = (currentIndex + 1) % size;
                remaining--;
                return element;
            }
        };
    }

}
