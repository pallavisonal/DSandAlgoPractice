import java.util.ArrayList;
import java.util.Scanner;

public class FindIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            list.add(new ArrayList<>(7));
        }
        for(int i = 0; i < 4; i++ ){
            for(int j = 0; j < 7; j++) {
                list.get(i).add(j, sc.nextInt());
            }
        }
        System.out.println(findIslands(list, 4, 7));
    }
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M)
    {
        int rows = N;
        int cols = M;
        boolean[][] visited = new boolean[rows][cols];
        int row = 0;

        int sum = 0;
        while(row < rows) {
            int col = 0;
            while (col < cols) {
                if (!visited[row][col]) {
                    sum += hasIsland(list, row, col, visited);
                }
                col++;
            }
            row++;
        }
       return sum;

    }

    private static int hasIsland(ArrayList<ArrayList<Integer>> list, int row , int col, boolean[][] visited) {
        visited[row][col] = true;
        int count = 0;
        if(list.get(row).get(col) == 1) {
            count++;
            for (int i = (row - 1 >= 0 ? row - 1: row); i < ((row + 2 > list.size() ? row + 1: row + 2)); i++) {
                for(int j = (col - 1 >= 0 ? col - 1: col); j < ((col + 2 > list.get(i).size() ? col + 1: col + 2)); j++) {
                    if(!visited[i][j] && list.get(i).get(j) == 1) {
                        hasIsland(list, i, j, visited);
                    }
                }
            }

        }
        return count;
    }
}
