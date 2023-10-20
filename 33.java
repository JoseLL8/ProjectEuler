//the problem specifies that the fractions we look for have 2 digits in both numbers and are less than 1 in value (that is, numerator<denomiator)
//i guess i could do something more sophisticated, but my implementation simply generates every fraction and checks it
import java.util.*;

class Problem33 {
	public static void main(String[] args) {
		int depth = 50; //50 digits precision is deemed acceptable for this problem
		String fraction;
		int k1;
		int k2;
		boolean unique;
		ArrayList<ArrayList<String>> m1 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> m2 = new ArrayList<ArrayList<String>>();
		ArrayList<String> aux;
		for (int n1=1; n1<9; n1++) { //single digit fractions
			for (int n2=n1+1; n2<10; n2++) { //always a fraction of value less than 1
				unique = true;
				fraction = intDivision(n1, n2, depth);
				for (ArrayList<String> l : m1) {
					if (fraction.equals(l.get(0))) {
						l.add(String.valueOf(n1));
						l.add(String.valueOf(n2));
						unique = false;
						//System.out.println(n1+"/"+n2+" matches with the stored fraction "+fraction);
						break;
					}
				}
				if (unique) {
					aux = new ArrayList<String>();
					aux.add(fraction);
					aux.add(String.valueOf(n1));
					aux.add(String.valueOf(n2));
					m1.add(aux);
					//System.out.println("New fraction "+fraction+ " added, as result of "+n1+"/"+n2);
				}
			}
		}
		for (int n1=12; n1<98; n1++) { //double digit fractions
			if (n1%10==n1/10 || n1%10==0) continue; //numbers with 2 of the same digit or a 0 are skipped, like 11, 33, 50...
			for (int n2=n1+1; n2<99; n2++) { //always a fraction of value less than 1
				if (n2%10==n2/10 || n2%10==0) continue;
				unique = true;
				fraction = intDivision(n1, n2, depth);
				for (ArrayList<String> l : m2) {
					if (fraction.equals(l.get(0))) {
						l.add(String.valueOf(n1));
						l.add(String.valueOf(n2));
						unique = false;
						//System.out.println(n1+"/"+n2+" matches with the stored fraction "+fraction);
						break;
					}
				}
				if (unique) {
					aux = new ArrayList<String>();
					aux.add(fraction);
					aux.add(String.valueOf(n1));
					aux.add(String.valueOf(n2));
					m2.add(aux);
					//System.out.println("New fraction "+fraction+ " added, as result of "+n1+"/"+n2);
				}
			}
		}
		int a1;
		int a2;
		int b1;
		int b2;
		int r1 = 1; //numerator
		int r2 = 1; //denominator
		for (ArrayList<String> l1 : m1) {
			for (ArrayList<String> l2 : m2) {
				if (l1.get(0).equals(l2.get(0))) {
					for (int a=1; a<l1.size(); a+=2) {
						a1 = Integer.parseInt(l1.get(a));
						a2 = Integer.parseInt(l1.get(a+1));
						for (int b=1; b<l2.size(); b+=2) {
							b1 = Integer.parseInt(l2.get(b));
							b2 = Integer.parseInt(l2.get(b+1));
							if ((a1==b1/10 && a2==b2%10 && b1%10==b2/10) || (a1==b1%10 && a2==b2/10 && b1/10==b2%10)) {
								//System.out.println(a1+"/"+a2+" = "+b1+"/"+b2);
								r1*=a1; //result is from the multiplication of the fractions, we use the smaller 1 digit versions
								r2*=a2;
							}
						}
					}
				}
			}
		}
		for (int i=2; i<=r1; i++) { //the solution is the denominator in the smallest possible form
			if (r1%i==0 && r2%i==0) {
				r1 /= i;
				r2 /= i;
				i = 2;
			}
		}
		System.out.println(r2);
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
