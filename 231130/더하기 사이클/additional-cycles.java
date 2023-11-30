import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;
public class Main {
    public static int firstDigit(int num) {
		String x = Integer.toString(num);
		int answer = x.charAt(x.length()-1)-'0';
		//System.out.println(answer);
		return answer;
	}
	public static int add(int num) {
		int sum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).sum();
		//System.out.println("sum:"+sum);
		return firstDigit(num)*10+firstDigit(sum);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initial = Integer.parseInt(br.readLine());
		int number = initial;
		int cnt = 0;
		while(true) {
			number = add(number);
			cnt++;
			if(number == initial) {
				System.out.print(cnt);
				break;
			}
			
		}
			
}
}