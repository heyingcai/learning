package com.jibug.learning.datastructure.search;

/**
 * 二分查找
 *
 * @author heyingcai
 */
public class BinarySearch {

    public static void main(String[] args) {
        //有序数组
        int[] array = {2, 5, 8, 10, 111, 302};

        int index = binarySearch(array, 0, array.length, 111);
        System.out.println("searchValue index : " + index);
    }

    public static int binarySearch(int[] array, int left, int right, int searchValue) {
        if (left > right) {
            return -1;
        }

        int midIndex = (left + right) / 2;
        int midValue = array[midIndex];
        //向左递归
        if (searchValue < midValue) {
            return binarySearch(array, left, midIndex - 1, searchValue);
        } else if (searchValue > midValue) {
            return binarySearch(array, midIndex + 1, right, searchValue);
        } else {
            return midIndex;
        }
    }

}
