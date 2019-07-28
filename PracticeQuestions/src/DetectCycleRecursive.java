import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int nov = sc.nextInt();
        int edg = sc.nextInt();
        for(int i = 0; i < nov; i++)
            list.add(i, new ArrayList<>());
        for(int i = 1; i <= edg; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }
        System.out.println(list);
        System.out.println(isCyclic(list, nov));

    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        boolean visited[] = new boolean[V];
        int count = 0;
        boolean hasCycle = false;
        while(!hasCycle && count < V) {
            if (!visited[count]) {
                hasCycle= isCyclePresent(list, count, -1 , visited);
            }
            count++;
        }
        return hasCycle;
    }

    static boolean isCyclePresent(ArrayList<ArrayList<Integer>> list, int parent , int topParent, boolean visited[]) {
        ArrayList<Integer> aList = list.get(parent);
        visited[parent] = true;
        if(aList.contains(parent)){
            return true;
        }
        for (Integer item : aList) {
            if(!visited[item]) {
                if(isCyclePresent(list, item, parent, visited)) {
                    return true;
                }
            }else {
                if (!item.equals(topParent)) {
                    return true;
                }
            }
        }
        return false;
    }
}
