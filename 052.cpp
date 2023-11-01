#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

bool checkPerm(int n1, int n2) { //checks if n1 and n2 are permutations of one another. i used string, probably not very efficient
    string s1 = to_string(n1);
    sort(s1.begin(), s1.end());
    string s2 = to_string(n2);
    sort(s2.begin(), s2.end());
    return s1==s2;
}

int main()
{
	int target = 6;
	int result = 0;
	for (int i=pow(10, target-1); !result; i++) { //result is also used to check if an answer has been found
		int aux = i;
		for (int k=1; k<target; k++) { //check i against 2i, 3i, 4i...
			aux += i;
			if (!checkPerm(i, aux)) { //k*i is not a permutation, stop checking
				break;
			}
			if (k==target-1) { //answer reached
				result = i;
			}
		}
	}
	cout << result << endl;
}
