// Your First Program

import java.util.*;

class Problem4 {
	public static void main(String[] args) {
		int p1 = 999;
		int p2 = 999;
		long limit = (long) 12;
		long result = (long) 0;
		while (p1>99) {
			limit = (long) p1*p2;
			if (isPalindrome(limit) && limit>result) {result=limit; p1--; p2=p1;}
			else {
				if (p2 > 99) {p2--;}
				else {p1--; p2=p1; if (p1*p2<result){break;};}
			}
		}
		System.out.println(result);
	}

	public static boolean isPrime(long n) {
		if (n%2==0) {return false;}
		int i = 1;
		while (i < Math.sqrt(n)) {
			i += 2;
			if (n%i==0) {return false;}
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
