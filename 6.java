// Your First Program

import java.util.*;

class Problem6 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ArrayList<Integer> factors = new ArrayList<Integer>();
		long n1 = (long) Math.pow((1+n)*(n/2),2);
		long n2 = 0;
		for (int i=1; i<=n; i++) {
			n2 += Math.pow(i,2);
		}
		System.out.println(n1-n2);
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
