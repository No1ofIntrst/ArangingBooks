import java.util.Scanner;
import java.lang.Math;

/**
 * This file should take in a string like "LSM"
 * And tell how many swaps are needed to get it in descending order
 * Like "LMS"
 */

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] myChars = input.nextLine().toCharArray();

		int numL = 0, numM = 0, numS = 0;
		for (char element : myChars) {
			if (element == 'L') {
				numL += 1;
			} else if (element == 'M') {
				numM += 1;
			} else {
				numS +=1;
			}
		}

		//System.out.println("NumL: " + numL + " NulM: " + numM + " NumS: " + numS);

		int SinL = 0, MinL = 0;
		for (int i = 0; i < numL; i++) {
			if (myChars[i] == 'M') {
				MinL += 1;
			} else if (myChars[i] == 'S') {
				SinL += 1;
			}
		}

		int SinM = 0, LinM = 0;
		for (int i = numL; i < numL + numM; i++) {
			if (myChars[i] == 'S') {
				SinM += 1;
			} else if (myChars[i] == 'L') {
				LinM += 1;
			}
		}

		int LinS = 0, MinS = 0;
		for (int i = numL + numM; i < myChars.length; i++) {
			if (myChars[i] == 'L') {
				LinS += 1;
			} else if (myChars[i] == 'M') {
				MinS += 1;
			}
		}

		int ops = 0;

		ops += Math.max(MinS, SinM);
		ops += Math.max(SinL, LinS);
		ops += Math.max(MinL, LinM);

		ops -= Math.abs(MinS - SinM);

		System.out.println(ops);
	}
}
