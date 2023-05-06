package xxw.template.login.backend.loginbackend;

import java.util.Arrays;

/**
 * 快排-分治算法
 *
 */
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    /**
     * 分治核心
     * pivot：子数组的基准元素
     * i：子数组中比基准元素小的最后一个元素的下标
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

//    public static void main(String[] args) {
//        int[] arr = {5, 2, 9, 7, 1, 8, 3, 6, 4};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//    }
}