package com.example.arrays1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();
        StringListImpl str2 = new StringListImpl();
        stringList.add("Stroka1");
        System.out.println(stringList);

        stringList.add(0, "Str5");

        System.out.println(stringList);

        stringList.set(0, "str222");
        System.out.println(stringList);

        stringList.remove("str222");
//        stringList.remove("str222234"); исключение
        System.out.println(stringList);

        stringList.remove(0);
        System.out.println(stringList);

        stringList.add("123");
        stringList.add("456");
        System.out.println(stringList);
        stringList.contains("123");

        stringList.indexOf("456");

//        stringList.lastIndexOf("456");

        stringList.get(0);

        stringList.equals(str2);

        stringList.size();

        stringList.isEmpty();

        stringList.clear();
        System.out.println("stringList = " + stringList);

        System.out.println("stringList.toArray() = " + Arrays.toString(stringList.toArray()));

    }
}
