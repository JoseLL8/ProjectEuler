// Your First Program

import java.util.*;

class Problem15 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int right = n;
		int down = n;
		long result = loop(right, down);

		System.out.println(result);
	}

	public static long loop(int right, int down) {
		if (right == 0 && down == 0) {return 1;}
		else if (right == 0) {return loop(right, down-1);}
		else if (down == 0) {return loop(right-1, down);}
		else {return loop(right, down-1) + loop(right-1, down);}
	}

	public static int countFactors(int n) {
		int i = n/2;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		while (i>0) {
			if (n%i == 0) {factors.add(i);}
			i--;
		}
		factors.add(n);
		return factors.size();
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
