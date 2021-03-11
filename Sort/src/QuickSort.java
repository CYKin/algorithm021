/**
 * @ClassName: QuickSort
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2021/1/24 19:47
 * @Version: 1.0.0
 **/
public class QuickSort {

    public static void quickSort(int[] array, int begin, int end) {
        if (end < begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    static int partition(int[] a, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }
}