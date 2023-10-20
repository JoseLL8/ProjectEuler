import java.util.*;

class Problem43 {
	public static void main(String[] args) {
		int [] digits = {0,1,2,3,4,5,6,7,8,9};
		ArrayList<String> perms = new ArrayList<String>();
		allPerms(digits, 0, perms);
		long result = 0;
		for (String s : perms) {
			if ((s.charAt(3)-'0')%2!=0) continue;
			if ((s.charAt(2)+s.charAt(3)+s.charAt(4)-'0'*3)%3!=0) continue;
			if ((s.charAt(5)-'0')%5!=0) continue;
			if (Integer.parseInt(s.substring(4,7))%7!=0) continue;
			if (Integer.parseInt(s.substring(5,8))%11!=0) continue;
			if (Integer.parseInt(s.substring(6,9))%13!=0) continue;
			if (Integer.parseInt(s.substring(7,10))%17!=0) continue;
			//System.out.println(s);
			result += Long.parseLong(s);
		}
		System.out.println(result);
	}

	public static void allPerms(int[] arg, int i, ArrayList<String> perms) {
		if (arg.length<2) return;
		if (i==arg.length-1) { //one permutation reached
			String s = "";
			for (int c=0; c<arg.length; c++) s += String.valueOf(arg[c]);
			perms.add(s);
			return;
		}
		for (int k=i; k<arg.length; k++) {
			int aux = arg[i]; //swap values
			arg[i] = arg[k];
			arg[k] = aux;
			allPerms(arg, i+1, perms);
			aux = arg[i]; //undo swap
			arg[i] = arg[k];
			arg[k] = aux;
		}
	}

	public static boolean checkPandigit(String n, int digits) { //modified so that 0 is also present
		ArrayList<Integer> hits = new ArrayList<Integer>();
		for (int i=0; i<=digits; i++) hits.add(i);
		int aux;
		for (int k=0; k<n.length(); k++) {
			aux = hits.indexOf(n.charAt(k)-'0');
			if (aux==-1) return false;
			hits.remove(aux);
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
