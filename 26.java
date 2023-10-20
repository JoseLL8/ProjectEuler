//the answer is 983 with a cycle of length 982, so at least 1965 depth is required (twice the length of the cycle, +1 due to my function also counting the firs integer
import java.util.*;

class Problem26 {
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]); //up to what number is the program going to check
		int depth = Integer.parseInt(args[1]); //number of decimals generated in the division
		int max = 0;
		int aux = 0;
		int result = 0;
		String fraction;
		for (int i=2; i<=limit; i++) {
			fraction = intDivision(1, i, depth);
			if (fraction.length()!=depth+1) continue; //not a cyclical fraction (the +1 is because of the dot added
			aux = detectCycle(fraction);
			if (aux>max) {
				max = aux;
				result = i;
				//System.out.println("New max: "+result+" with value "+max);
			}
		}
		//System.out.println(detectCycle(intDivision(1,7,100)));
		System.out.println(result);
	}

	public static int detectCycle(String s) { //detects and returns longest cycle starting from the last position
		boolean hit;
		ArrayList<Character> pattern = new ArrayList<Character>();
		int k;
		for (int i=s.length()-1; i>s.length()/2; i--) { //skip the first 2 characters which in this case are 0. always
			pattern.add(s.charAt(i)); //doesnt really matter what character we start from because its a cycle, it should eventually repeat if enough decimals have been calculated
			//System.out.println("Adding "+s.charAt(i));
			hit = true;
			k = 0;
			for (char c : pattern) {
				//System.out.println("Checking "+c+" against "+s.charAt(s.length()-1-k-pattern.size()));
				if (c!=s.charAt(s.length()-1-k-pattern.size())) {hit = false; break;}
				k++;
			}
			if (hit) return pattern.size(); //cycle detected. if not broken, the loop will continue to detect the same loop as a bigger one each time a multiple of its length is reached
		}
		return 0; //no cycle detected
	}

	public static String intDivision(int ag, int bg, int depth) { //this only really works for a division in which the divisor is far larger, other cases will probably return weird results
		String result = "";
		int a = ag;
		int b = bg;
		int c = 0;
		for (int d=0; d<depth; d++) {
			c = 0;
			while (a>=b) {
				//System.out.println(a+" - "+b+ " = "+(a-b));
				a -= b;
				c++;
			}
			result += c;
			if (d==0) result += ".";
			if (a==0) break;
			a *= 10;
		}
		return result;

	}

	public static boolean checkPerm(int an, int bn) {
		ArrayList<Integer> hits = new ArrayList<Integer>();
		int aux;
		int a = an;
		while (a>0) {
			hits.add(a%10);
			a /= 10;
		}
		int b = bn;
		while (b>0) {
			aux = hits.indexOf(b%10);
			if (aux==-1) return false;
			hits.remove(aux);
			b /= 10;
		}
		if (hits.size()>0) return false;
		return true;
	}

	public static ArrayList<Integer> findFactors(int n,  ArrayList<Integer> primes) {
		if (n<1) {return new ArrayList<Integer>();}
		ArrayList<Integer> fprimes =  new ArrayList<Integer>();
		for (int p : primes) {if (n%p==0 && n!=p) fprimes.add(p); if(p>n) {break;}}
		ArrayList<Integer> pprimes =  new ArrayList<Integer>();
		for (int f : fprimes) {
			pprimes.add(f);
		}
		for (int f: fprimes) {
			int power = 2;
			while (n%(int)Math.pow(f,power)==0 && (int)Math.pow(f,power)<n) {pprimes.add((int)Math.pow(f,power)); power++;}
		}
		ArrayList<Integer> result =  new ArrayList<Integer>();
		ArrayList<Integer> aux =  new ArrayList<Integer>();
		for (int k : pprimes) {
			result.add(k);
		}
		for (int k1 : pprimes) {
			for (int k2 : pprimes) {
				if (k1<=k2) {continue;}
				if (n%(k1*k2)==0 && n!=k1*k2 && !result.contains(k1*k2) != aux.contains(k1*k2)) {aux.add(k1*k2);}
			}
		}
		while (aux.size()>0) {
			for (int r : aux) {result.add(r); pprimes.add(r);}
			aux =  new ArrayList<Integer>();
			for (int k1 : pprimes) {
				for (int k2 : pprimes) {
					if (k1<=k2) {continue;}
					if (n%(k1*k2)==0 && n!=k1*k2 && !result.contains(k1*k2) && !aux.contains(k1*k2)) {aux.add(k1*k2);}
				}
			}
		}
		result.add(1);
		//Collections.sort(result);
		return result;
	}

	public static ArrayList<Integer> primeList(int limit) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (limit>=2) {result.add(2);}
		int k = 3;
		boolean isPrime;
		while (k<=limit) {
			isPrime = true;
			for (int p : result) {
				if (k%p==0) {isPrime=false; break;}
				else if (p>(int)Math.sqrt(k)) {break;}
			}
			if (isPrime) {result.add(k);}
			k += 2;
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
