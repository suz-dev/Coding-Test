import java.util.Scanner;

public class N2884 {
	
	public static void main(String[] args) {
		Scanner alarm = new Scanner(System.in);
		int H = alarm.nextInt();    // hour 
		int M = alarm.nextInt();    // minute 
		alarm.close();
			
		if(M >= 45) {   
			System.out.println(H + ":" + (M - 45));
		}else if(M < 45 && H != 0){
			System.out.println((H - 1) + ":" + (60 + M - 45));
		}else if(H == 0 && M < 45){
			System.out.println((H + 23) + ":" + (60 + M - 45));
		}
				
	}
}
