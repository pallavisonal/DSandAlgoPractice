import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {1,4,5,2,9,6,3,8};
        arr = divide(arr, 0, arr.length -1);
        int[] arrayOfElements = {19, 4, 13, 9, 2, 7, 11};
        arrayOfElements = divide(arrayOfElements, 0, arrayOfElements.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrayOfElements));
    }

    public static int[] divide(int[] arr, int leftIndex, int rightIndex) {
        int[] interMresult = new int[rightIndex - leftIndex + 1];
        if(leftIndex == rightIndex) {
            interMresult[0] = arr[leftIndex];
           return interMresult;
        }
        int middle = (leftIndex + rightIndex) / 2;
        interMresult = merge(divide(arr, leftIndex , middle),
                divide(arr, middle + 1, rightIndex));
        return interMresult;

    }

    public static int[] merge(int[] leftArray, int[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        int [] result = new int[leftArray.length + rightArray.length];
        while(leftIndex < leftArray.length
                && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                result[index] = leftArray[leftIndex];
                index++;
                leftIndex++;
            }else {
                result[index] = rightArray[rightIndex];
                index++;
                rightIndex++;
            }
        }
        while(leftIndex <= leftArray.length - 1) {
            result[index] = leftArray[leftIndex];
            leftIndex++;
            index++;
        }
        while(rightIndex <= rightArray.length - 1) {
            result[index] = rightArray[rightIndex];
            rightIndex++;
            index++;
        }
        return result;
    }

}
