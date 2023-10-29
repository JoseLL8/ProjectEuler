#include <iostream>
#include <cmath>

using namespace std;

int sumPowers(int n, int p) {
    int result = 0;
    while (n > 0) {
        result += pow(n%10, p);
        n /= 10;
    }
    return result;
}

int main()
{
    int p = 5;
    int start = 1000; //arbitrary start
    int limit = sumPowers(9, p)*p; //kind of arbitrary end too
    int result = 0;
    for (int i=start; i<limit; i++) { //1 and 2 are not accounted for
        int n = i; //copy for checking
        if (sumPowers(n, p) == i) result += i;
    }
    cout << result << endl;
}
