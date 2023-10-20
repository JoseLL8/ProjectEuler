// Your First Program

class Problem2 {
	static long limit = 4000000;
	public static void main(String[] args) {
		System.out.println(loop(1,2));
	}

	public static int loop(int i1, int i2) {
		if (i2 >= limit) {return 0;}
		else if (i2 % 2 == 0) {return i2 + loop(i2, i1+i2);}
		else {return loop(i2, i1+i2);}
	}
}
