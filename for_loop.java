package loops;

import java.util.Scanner;

public class for_loop {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		System.out.println("number of times  to  print ");
		int vr=scr.nextInt();
		for(int i=1; i<=vr; i++) {
			for(int j= 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		scr.close();
	}

}
