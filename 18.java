// Your First Program

import java.util.*;

class Problem18 {
	public static void main(String[] args) {
		int depth = Integer.parseInt(args[0]);
		String input = "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 99 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
		ArrayList<ArrayList<Integer>> pyramid = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		int max = 1;
		int current = 0;
		for (int i=0; i<input.length()-1; i+=3) {
			row.add(Integer.parseInt(input.substring(i, i+2)));
			current += 1;
			if (current == max) {max++; current=0; pyramid.add(row); row = new ArrayList<Integer>();}
		}
		int index = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		for (int r=0;r<max-2;r++) {
			//System.out.println("Currently in row " + r + ", index " + index + ", number " + pyramid.get(r).get(index));
			//if (pyramid.get(r).get(index)<pyramid.get(r).get(index+1)) {index++;}
			//System.out.println(pyramid.get(r).get(index));
			index += pathPyramid(pyramid, r, index, (int)Math.min(depth,max-r-2));
			result.add(index);
			//System.out.println(pyramid.get(r).get(index));
		}
		//result.add(index);
		int sum = 0;
		int i = 0;
		for (int n : result) {
			//System.out.println(pyramid.get(i).get(n));
			sum+=pyramid.get(i).get(n);
			i++;
		}
		System.out.println(sum);
		//System.out.println(pathPyramid(pyramid, 3, 2, depth));
		/*for (int i2=0; i2<max-1; i2++) {
			for (int j=0; j<=i; j++) {
				System.out.print(pyramid.get(i2).get(j)+" ");
			}
		System.out.println("");
		}*/
	}

	public static int pathPyramid(ArrayList<ArrayList<Integer>> pyramid, int row, int column, int d) {
		int limit = (int) Math.pow(2,d);
		int r = row;
		int c = column;
		int aux = 0;
		int sum = 0;
		int max = 0;
		int result = 0;
		while (limit>0) {
			while (aux<=d) {
				sum += pyramid.get(r).get(c);
				//if (aux==d) {System.out.println(pyramid.get(r).get(c));}
				r++;
				if (((int)Math.pow(2, aux)&limit)!=0) {c++;}
				aux++;
			}
			//System.out.println(sum);
			if (sum>max) {max=sum; result=limit%2;}
			sum = 0;
			aux = 0;
			r = row;
			c = column;
			limit--;
		}
		return result;
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
