// Your First Program

import java.util.*;

class Problem19 {
	public static void main(String[] args) {
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int year = 1901;
		int end = 2001;
		int result = 0;
		int day = 6; //he calculado que el 6 de Enero es el primer domingo de 1901
		int month = 0;
		while (year<end) {
			day += 7;
			if ((month!=1 || year%4!=0 || (year%100==0 && year%400!=0)) && day>months[month]) {day -= months[month]; month++;}
			else if (month==1 && year%4==0 && (year%100!=0 || year%400==0) && day>29) { day -= 29; month++;}
			if (month > 11) {month = 0; year++;}
			if (day==1) {result++;}
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
