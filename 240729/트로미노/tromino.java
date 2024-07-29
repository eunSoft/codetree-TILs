import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 200;
    public static int n,m;
    public static int[][] map = new int[MAX_N][MAX_N];
                                        //위,오,아,왼
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //ㄱ 자 모양에 대해서 완전탐색

        int max = 0;
        for(int i=0; i<=n-2; i++){
            for(int j=0; j<=m-2; j++){
                max = Math.max(max,returnMax(i,j));
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<=m-3; j++){
                max = Math.max(max, (map[i][j] + map[i][j+1] + map[i][j+2]));
            }
        }
        for(int j=0; j<m; j++){
            for(int i=0; i<=n-3; i++){
                max = Math.max(max, (map[i][j] + map[i+1][j] + map[i+2][j]));
            }
        }
        System.out.println(max);
    }

    private static int returnMax(int x, int y) {
        int maxSum = map[x][y]+map[x+1][y]+map[x][y+1]+map[x+1][y+1];
        int answer = 0;
        for(int i=x; i<x+2; i++){
            for(int j=y; j<y+2; j++){
                int nowSum = maxSum - map[i][j];
                answer = Math.max(answer,nowSum);
            }
        }
        return answer;
    }
}