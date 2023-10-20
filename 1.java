// Your First Program

class Problem1 {
	static int limit = 1000;
	public static void main(String[] args) {
		System.out.println(loop(0,0));
	}

	public static int loop(int sum, int i) {
		if (sum >= limit) {
				if (sum == limit && i==2)  {return sum-1;}
				else if (sum - limit == 1 && i==4) {return sum-2;}
			return 0;
		} else {
			if (i==0) { //0, 15, 30, 45...
				return sum + loop(sum+3, i+1);
			}
			else if (i==1) { //3, 18, 33, 48...
				return sum + loop(sum+3, i+1);
			}
			else if (i==2) {//6, 21, 36, 51...
				return sum + sum - 1 + loop(sum+3, i+1);
			}
			else if (i==3) {//9, 24, 39, 54...
				return sum + loop(sum+3, i+1);
			}
			else {//12, 27, 42, 57...
				return sum + sum - 2 + loop(sum+3, 0);
			}
		}
	}
}
