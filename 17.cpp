#include <iostream>
#include <vector>

using namespace std;

vector<int> count = {4, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8}; //first 20 cases, from zero

int countLetters(int n) { //works up to 1000
    int result = 0;
    if (n >= 100 && n < 1000) {
		result += 7+count[n/100]; //"hundred" + the number of 100s
		if (n%100!=0) {result += 3; n %= 100;} //+"and", reduce number to last 2 digits
	}
	if (n<20) {result += count[n];}
	else if (n>=20 && n<100) {
		if (n%10!=0) {result += count[n%10];}
        switch (n/10) { //1x cases are included in count vector
            case 2:
            case 3:
            case 8:
            case 9:
                result += 6;
                break;
            case 4:
            case 5:
            case 6:
                result += 5;
                break;
            case 7:
                result += 7;
                break;
        }
	}
	else if (n==1000) {result=11;}

    return result;
}

int main()
{
    int target = 1000;
    int sum = 0;
    for (int i = 1; i <= target; i++) {
        sum += countLetters(i);
    }
    cout << sum << endl;
}
