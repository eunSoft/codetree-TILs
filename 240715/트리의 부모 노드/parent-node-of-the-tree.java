import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
//    https://www.codetree.ai/missions/9/problems/parent-node-of-the-tree/description

    public static int MAX_N = 100000;
    public static int n;
    public static boolean[] visited = new boolean[MAX_N+1];
    public static int[] parent = new int[MAX_N+1];
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N+1];

    public static void traversal(int x){
        //x에 연결된 간선 살펴보기
        for(int i=0; i<edges[x].size(); i++){
            int y = edges[x].get(i);
            if(!visited[y]){
                visited[y] = true;
                parent[y]=x;

                traversal(y);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //System.out.println(st);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[x].add(y);
            edges[y].add(x);
        }

        visited[1] = true;
        traversal(1);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}