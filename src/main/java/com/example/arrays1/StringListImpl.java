package com.example.arrays1;

import com.example.arrays1.exception.ArrayIsFullException;
import com.example.arrays1.exception.ElementNotFoundException;
import com.example.arrays1.exception.InvalidIndexException;
import com.example.arrays1.exception.NullItemException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] arr;
    private int size;

    public StringListImpl() {
        arr = new String[10];
    }

    public StringListImpl(int initSize) {
        arr = new String[initSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        arr[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            arr[size++] = item;
            return item;
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
        return null;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        arr[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index == size) {
            arr[size--] = null;
            return item;
        }
        System.arraycopy(arr, index + 1, arr, index, size - index);

        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = arr[index];

        if (index == size) {
            System.arraycopy(arr, index + 1, arr, index, size - index);

        }

        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == arr.length) {
            throw new ArrayIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }
}
