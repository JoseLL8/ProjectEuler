import java.util.*;

class Problem35 {
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		ArrayList<Integer> primes = primeList(limit);
		int digits=1;
		boolean circular;
		int aux1;
		int aux2;
		int result = 0;
		for (int p : primes) {
			if (p>=(int)Math.pow(10, digits)) {digits++;}
			circular = true;
			aux1 = p;
			for (int i=1; i<digits; i++) {
				aux2 = aux1%10;
				aux1 = aux1/10 + aux2 * (int)Math.pow(10, digits-1);
				if (!primes.contains(aux1)) {
					circular = false;
					break;
				}
			}
			if (circular) {
				//System.out.println(p);
				result++;
			}
		}
		System.out.println(result);
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
