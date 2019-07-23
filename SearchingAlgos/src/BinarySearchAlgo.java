import java.util.Arrays;

public class BinarySearchAlgo {
    public static void main(String[] args) {
        int[] arr = {2, 9, 1, 5, 8, 4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(search(5, arr));
        System.out.println(search(9, arr));
    }

    public static int search(int val, int[] arr) {
        int len = arr.length;
        return binarySearch(val, arr, 0, len - 1);

    }

    private static int binarySearch(int val, int[] arr, int leftIndex, int rightIndex) {
        if(leftIndex == rightIndex && arr[leftIndex] != val) {
            return -1;
        }
        int mid = (leftIndex + rightIndex) / 2;
        if(val == arr[mid]) {
            return mid;
        }
        if(val < arr[mid]) {
            //search left part of arr
            return binarySearch(val, arr, leftIndex, mid - 1);
        } else {
            //search right part of arr
            return binarySearch(val, arr, mid + 1, rightIndex );
        }
    }
}
