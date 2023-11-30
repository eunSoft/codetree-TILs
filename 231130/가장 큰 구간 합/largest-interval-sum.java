import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static int n;
    public static int m;
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
    
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
       for(int i=0; i<n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
       }

       //구간합
       
       int max = 0;
       int cnt = 1;
       for(int i=0; i<n-m; i++){
        int sum = 0;
        for(int j=i; j<i+m; j++){
            sum += arr[j];
        }
        max = Math.max(max,sum);
        if(max == sum) cnt++;
        else cnt = 1;
       }
       System.out.println(max);
       if(max!=0) System.out.println(cnt);
    
    }
}