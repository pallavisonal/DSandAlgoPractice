import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        buildHeap(arr, 5);
        for(int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));
    }

    static void buildHeap(int[] newArr, int n) {
        for (int i = n / 2; i >= 0; i--) {
            int largestIndex = i;
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            if(left < n) {
                if (newArr[i] < newArr[left]) {
                    largestIndex = left;
                }
            }
            if(right < n) {
                if (newArr[i] < newArr[right]) {
                    largestIndex = right;
                }
            }
            if (largestIndex != i) {
                swap(newArr, i, largestIndex);
                buildHeap(newArr, n);
            }
        }
    }

    private static void swap(int[] newArr, int i, int largestIndex) {
        int temp = newArr[i];
        newArr[i] = newArr[largestIndex];
        newArr[largestIndex] = temp;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int len = n - i;
        buildHeap(arr, len);
    }
}
