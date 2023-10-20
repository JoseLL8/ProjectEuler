import java.util.*;

class Problem31 {
	public static void main(String[] args) {
		int target = Integer.parseInt(args[0]); //in pences
		ArrayList<Integer> coins = new ArrayList<Integer>(Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1)); //from bi to small
		int result = 0;
		int sum = 0;
		int i = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		boolean end = false;
		while (!end) { //greedy algorithm, expand all nodes
			while (sum+coins.get(i)>target) {
				i++; //use a smaller coin
			}
			sum += coins.get(i);
			path.add(i);
			if (sum==target) { //combination found
				result++;
				while (path.get(path.size()-1)==coins.size()-1) { //remove all the smallest coins
					path.remove(path.size()-1);
					sum -= 1;
					if (path.size()==0) {end=true; break;} //the combination made of only the smallest coins will always be the last one
				}
				if (!end) {
					path.add(path.remove(path.size()-1)+1); //use a smaller coin
					sum += coins.get(path.get(path.size()-1)) - coins.get(path.get(path.size()-1)-1);
					i = path.get(path.size()-1);
				}
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
