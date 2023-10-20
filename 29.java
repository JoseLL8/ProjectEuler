//considering that the biggest term is 100^100, neither ints nor longs are going to cut it for this problem. i used a function which (slowly) can calculate indefinitely big powers (but is still somewhat limited to the size of the base)
//i use a set to avoid repetitions, but checking for them manually in a more primitive data structure would be trivial, simply check if the element already exists, and if it doesnt then insert it
import java.util.*;

class Problem29 {
	public static void main(String[] args) {
		Set<String> powers = new HashSet<String>(); //sets do not allow repetition
		int limit = Integer.parseInt(args[0]);
		for (int a=2; a<=limit; a++) {
			for (int b=2; b<=limit; b++) {
				powers.add(slowPower(a,b));
			}
		}
		System.out.println(powers.size());
		/*int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println(slowPower(a,b));*/
	}

	public static String slowPower(int a, int b) {
		if (b==0) return "1";
		String result = "";
		ArrayList<Integer> mem = new ArrayList<Integer>();
		int aux = a;
		int carryover;
		while (aux>0) {
			mem.add(aux%10);
			aux /= 10;
		}
		for (int i = 1; i<b; i++) {
			aux = 0;
			for (int n = 0; n<mem.size(); n++) {
				aux = mem.get(n)*a+aux;
				mem.set(n, aux%10);
				aux /= 10;
				if (n==mem.size()-1) {
					while (aux>0) {
						mem.add(aux%10);
						aux /= 10;
					}
					break;
				}
			}
		}
		for (int n=mem.size()-1; n>=0; n--) result+=mem.get(n); //reverse the string for the returned value
		return result;
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
