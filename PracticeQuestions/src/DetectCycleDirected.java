import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleDirected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int nov = sc.nextInt();
        int edg = sc.nextInt();
        for(int i = 0; i < nov + 1; i++) {
            list.add(i, new ArrayList<>());
        }
        for(int i = 1; i <= edg; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
        }
        System.out.println(isCyclic(list, nov));
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
        int count = 0;
        boolean hasCycle = false;
        boolean[] visitedvert = new boolean[V];
        boolean[] visitedCount = new boolean[V];
        while(!hasCycle && count < V) {
            if(!visitedvert[count]) {
                hasCycle = isCyclePresent(list, count, visitedCount, visitedvert);
            }
            count++;
        }
        return hasCycle;
    }

    static boolean isCyclePresent(ArrayList<ArrayList<Integer>> list, int parent, boolean[] visited, boolean[] vistedvertex) {
        vistedvertex[parent] = true;
        visited[parent] = true;
        ArrayList<Integer> childList = list.get(parent);
        for(Integer child : childList) {
            if(visited[child]) {
                return true;
            }else {
                if(isCyclePresent(list, child, visited, vistedvertex)){
                    return true;
                }
            }
        }
        visited[parent] = false;
        return false;
    }
}
