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

        int index = binarySearch2(array, 0, array.length - 1, 1110);
        System.out.println("searchValue index : " + index);
    }

    /**
     * 递归
     *
     * @param array
     * @param left
     * @param right
     * @param searchValue
     * @return
     */
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

    /**
     * 迭代
     *
     * @param array
     * @param start
     * @param end
     * @param value
     * @return
     */
    public static int binarySearch2(int[] array, int start, int end, int value) {
        while (start <= end) {
            int midIndex = (start + end) / 2;
            int midValue = array[midIndex];
            if (midValue < value) {
                start = midIndex + 1;
            } else if (midValue > value) {
                end = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

}
