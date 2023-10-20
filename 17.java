// Your First Program

import java.util.*;

class Problem17 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int result = 0;
		while (n>0) {result += countLetters(n); n--;}
		System.out.println(result);
	}

	public static int countLetters(int n) {
		int result = 0;
		int[] count = {4, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
		if (n >= 100 && n < 1000) {
			result += 7+count[n/100];
			if (n%100!=0) {result += 3; n %= 100;}
		}
		if (n<20) {result += count[n];}
		else if (n>=20 && n<100) {
			if (n%10!=0) {result += count[n%10];}
			switch (n/10) {
				case 2:
				case 3:
				case 8:
				case 9:
					result += 6;
					break;
				case 4:
				case 5:
				case 6:
					result += 5;
					break;
				case 7:
					result += 7;
					break;
			}
		}
		else if (n==1000) {result=11;}
		return result;
	}

	public static boolean isPrime(long n) {
		if (n%2==0&&n!=(long)2) {return false;}
		int i = 1;
		while (i < Math.sqrt(n)) {
			i += 2;
			if (n%i==0&&n!=(long)3) {return false;}
		}
		return true;
	}

	public static boolean isPalindrome(long n) {
		String s = String.valueOf(n);
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i)!=s.charAt(s.length()-1-i)) {return false;}
		}
		return true;
	}
}
