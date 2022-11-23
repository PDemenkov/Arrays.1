package com.example.arrays1;

import java.io.FilterOutputStream;
import java.util.ArrayList;


public class StringListImpl implements StringList {
    ArrayList<String> list = new ArrayList<>(2);

    @Override
    public String add(String item) {
        list.add(item);
        System.out.println("Added " + item);
        return item;
    }

    @Override
    public String add(int index, String item) {
        list.add(index, item);
        if (list.size() > 2) {
            throw new RuntimeException();
        }
        System.out.println("Added " + item + "on index " + index);
        return item;
    }

    @Override
    public String set(int index, String item) {
        list.set(index, item);
        if (list.size() > 2) {
            throw new RuntimeException();
        }
        System.out.println("Setted " + item + "on index " + index);
        return item;
    }

    @Override
    public String remove(String item) {
        if (!list.contains(item)) {
            throw new RuntimeException();
        }
        list.remove(item);
        System.out.println("Deleted " + item);
        return item;
    }

    @Override
    public String remove(int index) {
        if (list.get(index) == null) {
            throw new RuntimeException();
        } else list.remove(index);
        System.out.println("Deleted on index " + index);
        return String.valueOf(index);
    }

    @Override
    public boolean contains(String item) {
        System.out.println(list.contains(item));
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (list.contains(item)) {
            System.out.println(list.indexOf(item));
        } else {
            System.out.println("-1");
        }
        return Integer.parseInt(item);
    }

    @Override
    public int lastIndexOf(String item) {
        if (list.contains(item)) {
            System.out.println(lastIndexOf(item));
        } else {
            System.out.println("-1");
        }
        return Integer.parseInt(item);
    }

    @Override
    public String get(int index) {
        if (index > list.size()) {
            throw new RuntimeException();
        } else {
            System.out.println(list.get(index));
        }
        return String.valueOf(index);
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new RuntimeException();
        }
        if (list.equals(otherList)) {
            System.out.println(true);
        } else System.out.println(false);
        return otherList.isEmpty();
    }

    @Override
    public int size() {
        System.out.println(list.size());
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if (list.isEmpty()) {
            System.out.println(true);
        } else System.out.println(false);
        return false;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String[] toArray() {
        list.toArray();
        return new String[2];
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "list=" + list +
                '}';
    }
}
