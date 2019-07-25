import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
* complete the function bfs() which do BFS of the given graph starting
* from node 0 and prints the nodes in BFS order.
*/

public class TraversalBF {
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
        Queue<Integer> queue = new ArrayDeque<>();
        if(!vis[s]) {
           queue.add(s) ;
        }
        while(!queue.isEmpty()) {
            Integer item = queue.poll();
            if(!vis[item]) {
                ArrayList<Integer> aList = list.get(item);
                for(Integer elem : aList) {
                    if(!vis[elem]) {
                        queue.add(elem);
                    }
                }
                System.out.println(item + " ");
                vis[item] = true;
            }
        }

    }
}
