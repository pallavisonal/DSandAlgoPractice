import java.util.ArrayList;
import java.util.Scanner;
/* Depth First Traversal of a graph using
* recursive approach
*/
public class TraversalDFSRecursive {
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
        boolean[] vis = new boolean[nov];
        for(int i = 0; i < nov; i++)
            vis[i] = false;
        dfs(0, list, vis);
    }
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
        if(!vis[src]) {
            System.out.print(src + " ");
            vis[src] = true;
            ArrayList<Integer> childList = list.get(src);
            if(childList.size() == 0) {
                return;
            }
            for(Integer child : childList) {
                dfs(child, list, vis);
            }
        }
    }
}
