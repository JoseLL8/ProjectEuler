// Lowest depth that returned the correct answer: 22
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Problem67 {
	public static void main(String[] args) {
		int depth = Integer.parseInt(args[0]);
		ArrayList<ArrayList<Integer>> pyramid = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		int max = 1;
		try {
			File input = new File("p067_triangle.txt");
			Scanner lector = new Scanner(input);
			while (lector.hasNextLine()) {
				String line = lector.nextLine();
				for (int i=0; i<line.length()-1; i+=3) {
					row.add(Integer.parseInt(line.substring(i, i+2)));
				}
				pyramid.add(row);
				row = new ArrayList<Integer>();
				max++;
			}
			lector.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
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
			for (int j=0; j<=i2; j++) {
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
