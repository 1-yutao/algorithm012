package org.millet.algorithm.week_08;

import java.util.Arrays;

/**
 * 排序
 * Created by yutao
 * Create date 2020/8/29 20:54
 */
public class Sort {

    /**
     * 冒泡排序法
     * @param arrays
     */
    public void bubbleSort(int[] arrays) {
        int len = arrays.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序法
     * @param arrays
     */
    public void selectSort(int[] arrays) {
        int len = arrays.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i; j < len; j++) {
                if (arrays[j] < arrays[i]) {
                    minIndex = j;
                }
            }
            temp = arrays[i];
            arrays[i] = arrays[minIndex];
            arrays[minIndex] = temp;
        }
    }

    /**
     * 插入排序法
     * @param arrays
     */
    public void insertionSort(int[] arrays) {
        int len = arrays.length;
        int proIndex, current;
        for (int i = 1; i < len; i++) {
            proIndex = i -1;
            current = arrays[i];
            while (proIndex >= 0 && arrays[proIndex] > current) {
                arrays[proIndex + 1] = arrays[proIndex];
                proIndex--;
            }
            arrays[proIndex + 1] = current;
        }
    }

    /**
     * 希尔排序
     * @param arrays
     */
    public void shellSort(int[] arrays) {
        int len = arrays.length;

        for (int gap = len/2; gap > 0; gap = gap/2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int curren = arrays[i];
                while (j - gap >= 0 && curren < arrays[j - gap]) {
                    arrays[j] = arrays[j - gap];
                    j = j - gap;
                }
                arrays[j] = curren;
            }
        }
    }

    /**
     * 归并排序
     *
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }

    /**
     * 快速排序
     * @param array
     * @param begin
     * @param end
     */
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();

        int[] arrays = {5,2,3,6,1};
        sort.quickSort(arrays, 2, 3);

        System.out.println(Arrays.toString(arrays));
    }
}
