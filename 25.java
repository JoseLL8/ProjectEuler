// Your First Program

import java.util.*;

class Problem25 {
	public static void main(String[] args) { //i used truncation in order to minimize workload while still using reasonable precision. imp retty sure this sequence follows some pattern for which indexes represent the addition of a new digit, but honestly im fine with this, it works well and within reasonable time. for the 1000 question it doesnt even take a second
		int limit = Integer.parseInt(args[0]);

		long a = 1;
		long b = 1;
		long c = 1;
		int i = 2;
		if (limit<7) {
			while (c/(long)Math.pow(10,limit-1)==0) {
				i++;
				c = a+b;
				a = b;
				b = c;
			}
		}
		else {
			int e = 6;
			while (e<limit) {
				i++;
				c = a + b;
				if (c>1000000) {c/=10; b/=10; e++;}
				a = b;
				b = c;
			}
		}
		System.out.println("index="+i);
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
