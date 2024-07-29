import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static int n,m;
    public static int happyCnt = 0;

    public static int[][] map = new int[MAX_N][MAX_N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(n==1) {
            System.out.println(2);
            return;
        }
        //행에 대해서 비교
        int continuity = 0;

        for(int i=0; i<n; i++){
            int recent = map[i][0];
            for(int j=0; j<n; j++){
                if(j==0) {
                    continuity++;
                    continue;
                }
                if(recent == map[i][j]) continuity++;
                else {
                    continuity = 1;
                    recent = map[i][j];
                }
            }
            if(continuity>=m) happyCnt++;
        }
        continuity = 0;
        
        for(int i=0; i<n; i++){
            int recent = map[0][i];
            for(int j=0; j<n; j++){
                if(j==0) {
                    continuity++;
                    continue;
                }
                if(recent == map[j][i]) continuity++;
                else {
                    continuity = 1;
                    recent = map[j][i];
                }
            }
            if(continuity>=m) happyCnt++;
        }
        System.out.println(happyCnt);



    }
}