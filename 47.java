//i modified my function for finding factors in order to suit this problem
import java.util.*;

class Problem47 {
	public static void main(String[] args) { //the first number is the limit of calculations, the second is the size of the target series. if the limit is too low related to the size of the sequence, no solution will be found
		int limit = Integer.parseInt(args[0]); //limit of calculations. the sequence starts at 134043, so a limit of 134050 should do it
		int target = Integer.parseInt(args[1]); //number of consecutive numbers
		int c = 0;
		ArrayList<Integer> primes = primeList(limit);
		ArrayList<ArrayList<Integer>> factors = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> aux = new ArrayList<Integer>();
		boolean check;
		for (int i=0; i<limit; i++) {
			aux = findFactors(i, primes);
			if (aux.size()!=target) {c=0; result.clear(); factors.clear(); continue;} //reset count
			check = true;
			for (ArrayList<Integer> f : factors) if (!checkUnmatch(aux, f)) check = false; //needs to have unique factors
			if (check) {
				result.add(i);
				factors.add(aux);
				c++;
				if (c==target) break; //target reached
			}
		}
		//for (int r : result) System.out.println(r);
		if (result.size()==target) System.out.println(result.get(0)); //only the first number is asked
	}

	public static boolean checkUnmatch(ArrayList<Integer> a, ArrayList<Integer> b) { //assumes that both are of the target size
		Collections.sort(a);
		Collections.sort(b);
		int bn = 0;
		for (int an : a) {
			while (an>b.get(bn)&&bn<b.size()-1) {
				bn++;
			}
			if (an==b.get(bn)) return false; //at least one match
		}
		return true;
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

	public static ArrayList<Integer> findFactors(int n,  ArrayList<Integer> primes) { //modified version, only returns powers of primes (including power 1 of course)
		if (n<1) {return new ArrayList<Integer>();}
		ArrayList<Integer> fprimes =  new ArrayList<Integer>();
		for (int p : primes) {if (n%p==0 && n!=p) fprimes.add(p); if(p>n) {break;}}
		ArrayList<Integer> pprimes =  new ArrayList<Integer>();
		for (int f : fprimes) {
			pprimes.add(f);
		}
		ArrayList<Integer> aux =  new ArrayList<Integer>();
		for (int f: fprimes) {
			int power = 2;
			while (n%(int)Math.pow(f,power)==0 && (int)Math.pow(f,power)<n) {
				pprimes.add((int)Math.pow(f,power));
				aux.add((int)Math.pow(f,power-1)); //values to delete later
				power++;
			}
		}
		ArrayList<Integer> result =  new ArrayList<Integer>();
		for (int k : pprimes) {
			result.add(k);
		}
		for (int a : aux) result.remove(result.indexOf(a));
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
