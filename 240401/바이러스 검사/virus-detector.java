import java.util.*;
import java.io.*;

public class Main {
    public static int MAX_N = 1000000;
    public static int n;
    public static int pm,pl;
    public static List<Integer> map = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        pm = Integer.parseInt(st.nextToken());
        pl = Integer.parseInt(st.nextToken());

        System.out.println(getMin());


    }

    public static Long getMin(){
        long result = 0;
        for(int i=0; i<map.size(); i++){
            result++;
            int people = map.get(i)-pm;
            if(people < 0 ) continue;
            result += people / pl; 
            if(people % pl !=0) result++;
        }
        
        return result;
    }
}