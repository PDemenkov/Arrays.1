package com.example.arrays1;

import java.util.Arrays;
import java.util.Random;

public class FastestSort {
    public static void main(String[] args) {
        int [] arrayInt = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arrayInt.length-1; i++) {
            arrayInt[i] = random.nextInt();
        }

        int[] copy1 = Arrays.copyOf(arrayInt, arrayInt.length);
        int[] copy2 = Arrays.copyOf(arrayInt, arrayInt.length);
        System.out.println(Arrays.equals(arrayInt, copy1)); // проверка массивов
        System.out.println(Arrays.equals(arrayInt, copy2));

        long start = System.currentTimeMillis();

        sortBubble(arrayInt);
        System.out.println(System.currentTimeMillis() - start + " sortBubble"); //Самая быстрая


        sortInsertion(copy1);
        System.out.println(System.currentTimeMillis() - start + " sortInsertion");

        sortSelection(copy2);
        System.out.println(System.currentTimeMillis() - start + " sortSelection");


    }
    public static void swapElements(int[] arr,int indexA,int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(int[] arr) { //самая быстрая
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr,j,j+1);
                }
            }
        }
    }

    //Сортировка выбором
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            } swapElements(arr,i,minElementIndex);
        }
    }

    //Сортировка вставкой

    public static void sortInsertion(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;

        }
    }
    // Линейный поиск
    public static boolean contains(int[] arr, int element) {
        for (int i : arr) {
            if (i == element) {
                return  true;
            }
        }
        return false;
    }

    //Бинарный поиск
    public static boolean contains1(int[] arr, int element) {
        int min =0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == arr[mid]) {
                return true;
            }
            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        } return false;
    }
}
