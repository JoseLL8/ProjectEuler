// Your First Program

import java.util.*;

class Problem5 {
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int i = 2;
		while (i<limit) {
			if (isPrime(i)) {
				int j = 2;
				while ((int) Math.pow(i,j)<limit) {j++;}
				factors.add((int) Math.pow(i,j-1));
			}
			if (i==2) {i++;}
			else {i+=2;}
		}
		int result = 1;
		for (int k : factors) {
			result *= k;
			System.out.println(k);
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
