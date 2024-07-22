import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX_N = 20;
    public static int n;
    public static int maxCoin = 0;
    public static int[][] map = new int[MAX_N][MAX_N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                checkCoinCnt(i,j);
            }
        }
        System.out.println(maxCoin);

    }
    static void checkCoinCnt(int startx, int starty){
        int cnt = 0;
        for(int i=startx; i<startx+3; i++){
            for(int j=starty; j<starty+3; j++){
                cnt+=map[i][j];
            }
        }
        maxCoin = Math.max(maxCoin,cnt);
    }
}