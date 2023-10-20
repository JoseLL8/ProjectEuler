import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Problem22 {
	public static void main(String[] args) {
		try {
			File input = new File("p022_names.txt");
			Scanner lector = new Scanner(input);
			String line = lector.nextLine();
			lector.close();
			ArrayList<String> names = new ArrayList<String>();
			int bookmark = 0;
			for (int i=0; i<line.length(); i++) {
				if (line.charAt(i) == ',') {
					//System.out.println(line.substring(bookmark+1,i-1));
					names.add(line.substring(bookmark+1,i-1));
					bookmark=i+1;
				}
			}
			//System.out.println(line.substring(bookmark+1, line.length()-1));
			names.add(line.substring(bookmark+1, line.length()-1));
			Collections.sort(names);
			long result = 0;
			int sum = 0;
			int k = 1;
			for (String name : names) {
				for (int c=0; c<name.length(); c++) {
					sum += name.charAt(c) - '@';
				}
				result += sum*k;
				sum = 0;
				k++;
				//System.out.println(name);
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
