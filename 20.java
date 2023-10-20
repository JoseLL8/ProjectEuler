// Your First Program

import java.util.*;

class Problem20 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		int aux = 0;
		int co = 0;
		while (n>1) {
			//System.out.println("iteration "+n);
			for (int i=0; i<nums.size(); i++) {
				aux = nums.get(i)*n+co;
				//System.out.println("multiplying "+nums.get(i)+" * "+n+" with carryover "+co);
				co = aux/10;
				//if (co>10) {System.out.println("carryover = "+co+" ,aux = "+aux);}
				nums.set(i, aux%10);
			}
			//System.out.println("");
			while (co>0) {nums.add(co%10); co/=10;}
			n--;
		}
		long result = 0;
		for (int j : nums){
			result += j;
			//System.out.println(j);
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
