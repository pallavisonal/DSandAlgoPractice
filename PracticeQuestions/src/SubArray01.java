import java.util.HashMap;

/*
 *Given an array of 0's and 1's your task is to complete the function maxLen
 *which returns size of the largest sub array with equal number of 0's and 1's.
 * 0 1 0 1
 * 4
 * 0 0 1 0 0
 * 2
 */
public class SubArray01 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0 };
        System.out.println(maxLen(arr));
    }
    static int maxLen(int[] arr)
    {
        int len = arr.length;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        for(int i = 0; i < len; i++) {
            map.put(arr[i], map.get(arr[i]) + 1);
            for(int j = i + 1; j < len; j++) {
                map.put(arr[j], map.get(arr[j]) + 1);
                if(map.get(0) == map.get(1)) {
                    int sum = map.get(0) + map.get(1);
                    maxLen = Math.max(sum, maxLen);
                }
            }
            map.put(0, 0);
            map.put(1, 0);
        }
        return maxLen;
    }
}
