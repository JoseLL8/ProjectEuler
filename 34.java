// Your First Program

import java.util.*;

class Problem34 { //the only number other than 145 is 40585, so a relatively low limit will get the job done
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		ArrayList<Integer> factorials = new ArrayList<Integer>();
		int aux = 1;
		factorials.add(1); //0!
		for (int i=1; i<10; i++) {aux *= i; factorials.add(aux);}
		//for (int l : limits) {System.out.println(l);}
		int sum;
		int result = 0;
		for (int k=10; k<=limit; k++) { //single-digit numbers are not considered sums, so we start at 10
			aux=k;
			sum = 0;
			while (aux>0) {
				sum += factorials.get(aux%10);
				aux /= 10;
			}
			if (k==sum) {
				//System.out.println(k);
				result += k;
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
