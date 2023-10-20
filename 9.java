// Your First Program

import java.util.*;

class Problem9 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int c = n-2;
		int b = n-3;
		int a = n-4;
		while ( (a+b+c!=n) || ((int) Math.pow(a,2) + (int) Math.pow(b,2)) != (int) Math.pow(c,2) ) {
			a--;
			if (a<n-c-b || a<1) {b--; a=b-1;}
			if (b<(n-c)/2) {c--; b=c-1; a=b-1;}
			if (c<n/3) {System.out.println("Fin del bucle, c="+c);break;}
		}
		System.out.println(a+" * "+b+" * "+c+"= "+a*b*c);
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
