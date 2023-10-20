// Your First Program

import java.util.*;

class Problem24 { //undefined behaviour with repeated characters
	public static void main(String[] args) { //input in the form of Problem24 <charsArray> <number>. for solving the problem 24 it would be like: Problem24 0123456789 1000000
		int limit = Integer.parseInt(args[1])-1; //i fucked up the implementation and start counting at 0, with this quick fix i can pretend this program is perfectly functional xd
		ArrayList<Character> chars = new ArrayList<Character>();
		ArrayList<Integer> limits = new ArrayList<Integer>();
		for (int i=0; i<args[0].length(); i++) {chars.add(args[0].charAt(i));}
		Collections.sort(chars); //doesnt matter whether the characters are numerical or not, as long as they are distinct it works
		int aux = 1;
		for (int j=2; j<chars.size(); j++) {aux *= j; limits.add(aux);}
		//for (int l : limits) {System.out.println(l);}
		ArrayList<Integer> result = new ArrayList<Integer>();
		int pos = 0;
		int k = limits.size()-1;
		while (k>=0) {
			if (limit>=limits.get(k)) {
				//System.out.println("Adding 1 to position " + k);
				limit -= limits.get(k);
				pos++;
			}
			else {
				//limits.remove(pos);
				result.add(pos);
				pos = 0;
				k--;
			}
		}
		//System.out.println(limit);
		//for (int r : result) {System.out.println(r);}
		for (int r : result) {System.out.print(chars.get(r)) ;chars.remove(r);}
		System.out.print(chars.get(limit)); //only the first chars.size()-2 characters get printed, the remaining 2 are determined by the remaining value of limit, if it is 0 then the lesser character goes first, otherwise its the greater character that goes first
		System.out.println(chars.get(1-limit));
	}

	public static int perms(int n) { //possile number of permutations when sorting unique elements
		return 2;
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
