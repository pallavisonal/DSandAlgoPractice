import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        int count = 0;
        int index = 0;
        while(count < N) {
            if (!visited[count]) {
                sort(list, count, visited,stack);
            }
            count++;
        }
        while(!stack.isEmpty()) {
            result[N-1-index] = stack.pop();
            index++;
        }
        return result;
    }

    static void sort(ArrayList<ArrayList<Integer>> list, int parent, boolean[] visited, Stack<Integer> stack) {
        visited[parent] = true;
        ArrayList<Integer> childList = list.get(parent);
        for(Integer child : childList) {
            if(!visited[child]) {
                sort(list, child, visited, stack);
            }
        }
        stack.push(parent);
        return ;
    }

}
