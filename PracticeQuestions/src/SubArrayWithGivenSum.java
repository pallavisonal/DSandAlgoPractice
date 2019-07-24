import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
/*
 *Given an unsorted array A of size N of non-negative integers,
 * find a continuous sub-array which adds to a given number S.
 * print the starting and ending positions(1 indexing) of first such
 * occuring subarray from the left if sum equals to subarray, else print -1.
 * 12
 * 1 2 3 7 5  // output 2 4
 */

public class SubArrayWithGivenSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numTests = reader.readLine();
        if(numTests == null) {
            System.exit(1);
        }
        int numTestCases = Integer.valueOf(numTests);
        for(int i = 0; i < numTestCases; i++) {
            String secondInp = reader.readLine();
            if (secondInp == null) {
                System.exit(1);
            }
            String[] sizeAndSum = secondInp.trim().split(" ");
            if (sizeAndSum.length < 2) {
                System.exit(1);
            }
            int size = Integer.valueOf(sizeAndSum[0]);
            int sum = Integer.valueOf(sizeAndSum[1]);

            String listArrElements = reader.readLine();
            if (listArrElements == null) {
                System.exit(1);
            }
            String[] arrElements = listArrElements.trim().split(" ");
            if (arrElements.length < size) {
                System.exit(1);
            }
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = Integer.valueOf(arrElements[j]);
            }
            printSub(arr, sum);
        }
    }

    public  static void printSub(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        int rSum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == sum) {
                builder.append((i + 1) + " " + (i + 1));
                break;
            }
            rSum += arr[i];
            map.put(rSum, i + 1);
            if(rSum == sum) {
                builder.append(1 + " " + (i + 1));
                break;
            }
            if (rSum > sum) {
                int diff = rSum - sum;
                if(map.get(diff) != null) {
                    int startInd = map.get(diff) + 1;
                    builder.append(startInd + " " + (i + 1));
                    break;
                }
            }
        }
        if(builder.length() == 0) {
            System.out.println("-1");
        }else {
            System.out.println(builder.toString());
        }
    }
}