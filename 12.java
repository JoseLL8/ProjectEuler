// Your First Program

import java.util.*;

class Problem12 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int sum = 0;
		int i = 1;
		while (countFactors(sum)<=n) {sum += i; i++;}
		System.out.println(sum);
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
