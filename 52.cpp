#include <iostream>
#include <vector>

int check_perm(int n1, int n2) {
	std::vector<int> v = {};
	while (n1>0) {
		v.push_back(n1%10);
		n1 /= 10;
	}
	int i;
	int aux;
	while (n2>0) {
		aux = n2%10;
		for (i=0; i<=v.size(); i++) {
			if (i==v.size()) return 0;
			if (v[i]==aux) break;
		}
		v.erase(v.begin()+i);
		n2 /= 10;
	}
	if (!v.size() && !n2) return 1;
	return 0;
}

int main(int argc, char** argv) {
	if (argc!=2) {
		printf("Usage: ./51 <n>\n");
		return 0;
	}
	int n = atoi(argv[1]);
	int k = 1;
	int k2;
	int res;
	while (1) {
		k2 = k;
		res = k;
		for (int a=1; a<n; a++) {
			k2 += k;
			if (!check_perm(k, k2)) {res=0; break;}
			//printf("%d=%d, this is hit number %d\n", k, k2, a+1);
		}
		if (res) break;
		k++;
	}
	printf("%d\n", res);
	return 0;
}
