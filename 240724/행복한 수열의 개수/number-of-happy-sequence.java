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
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //탐색을 시작할 점 i,j
                //i가 0이라면 아래로만 탐색가능
                //j가 0이라면 옆으로만 탐색가능
                // 둘다 아니라면 탐색x
                if(i!=0 && j!=0) continue;

//                System.out.println(i+" "+j);
//                System.out.println("=============");
                check(i,j);
            }
        }
        System.out.println(happyCnt);



    }
    static void check(int startx, int starty){
        //System.out.println(startx+" "+starty);
        int continuity = 0;
        int recent = map[startx][starty];
        //System.out.println(recent);
        //x 가 0이라면 아래로 탐색
        //y 가 0이라면 오른쪽으로 탐색
        if(startx==0){

            for(int i=0; i<n; i++){
                //System.out.println(recent + " " + map[0][i]);
                // if(continuity>=m) {
                //     happyCnt++;
                //     break;
                // }
                if(recent == map[i][starty]) continuity++;
                else {
                    recent = map[i][starty];
                    continuity = 1;
                }
            }
            if(continuity>=m) happyCnt++;
        }
        if(starty==0)
            for(int i=0; i<n; i++){
                //System.out.println(recent + "  "+ map[i][0]);
                // if(continuity>=m) {
                //     happyCnt++;
                //     break;
                // }
                if(recent == map[startx][i]) continuity++;
                else{
                    recent = map[startx][i];
                    continuity = 1;
                }
            }
            if(continuity>=m) happyCnt++;

    }
}