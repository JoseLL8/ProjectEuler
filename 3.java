// Your First Program

import java.util.*;

class Problem3 {
	public static void main(String[] args) {
		long target = Long.parseLong(args[0]);
		ArrayList<Long> primes = new ArrayList<Long>();
		long factor = 1;
		while (target != 1) {
			if (factor<3) {factor++;}
			else {factor+=2;}
			boolean isPrime = true;
			for (long i : primes) {
				if (factor%i==0) {isPrime=false;break;}
				if (i>Math.sqrt(factor)) {break;}
			}
			if (isPrime) {
				primes.add(factor);
				while (target%factor==0) {
					target /= factor;
				}
			}
		}
		System.out.println(factor);
	}
}
