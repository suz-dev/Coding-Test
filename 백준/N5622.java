import java.io.IOException;
 
public class N5622 {
	
	public static void main(String[] args) throws IOException {
		
		int cnt = 0;
		int value;
		
		while(true) {
			
			value = System.in.read();
			
			if(value == '\n') {
				break;
			}
			
			if(value < 'D') {
				cnt += 3;
			}else if(value < 'G') {
				cnt += 4;
			}else if(value < 'J') {
				cnt += 5;
			}else if(value < 'M') {
				cnt += 6;
			}else if(value < 'P') {
				cnt += 7;
			}else if(value < 'T') {
				cnt += 8;
			}else if(value < 'W') {
				cnt += 9;
			}else {
				cnt += 10;
			}
			
			
		}
		System.out.print(cnt);
	}
}