import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Problem42 {
	public static void main(String[] args) {
		try {
			File input = new File("p042_words.txt");
			Scanner lector = new Scanner(input);
			String line = lector.nextLine();
			lector.close();
			ArrayList<String> words = new ArrayList<String>();
			int bookmark = 0;
			for (int i=0; i<line.length(); i++) {
				if (line.charAt(i) == ',') {
					//System.out.println(line.substring(bookmark+1,i-1));
					words.add(line.substring(bookmark+1,i-1));
					bookmark=i+1;
				}
			}
			//System.out.println(line.substring(bookmark+1, line.length()-1));
			words.add(line.substring(bookmark+1, line.length()-1));
			ArrayList<Integer> hits = new ArrayList<Integer>();
			int aux = 0;
			for (int j=1; j<20; j++) {
				aux += j;
				hits.add(aux);
			}
			int result = 0;
			int sum;
			for (String w : words) {
				sum = 0;
				for (int c=0; c<w.length(); c++) {
					sum += w.charAt(c)-'@';
				}
				if (hits.contains(sum)) {
					result++;
					//System.out.println(w);
				}
			}
			System.out.println(result);
		}

		catch (FileNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
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
