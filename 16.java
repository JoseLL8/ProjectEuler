// Your First Program

import java.util.*;

class Problem16 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		int aux = 0;
		int co = 0;
		while (n>0) {
			for (int i=0; i<nums.size(); i++) {
				aux = nums.get(i)*2+co;
				co = aux/10;
				nums.set(i, aux%10);
			}
			if (co!=0) {nums.add(co); co=0;}
			n--;
		}
		int result = 0;
		for (int j : nums){
			result += j;
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
