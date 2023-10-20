// Your First Program

import java.util.*;

class Problem7 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int result = 0;
		if (n==1) {result=2;}
		else {
			int i = 1;
			int current = 3;
			while (i<n) {
				if (isPrime(current)) {i++; result=current;}
				current += 2;
			}
		}
		System.out.println(result);
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
