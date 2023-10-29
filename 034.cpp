#include <iostream>
#include <cmath>
#include <set>

using namespace std;

int factorial(int n) {
    int res = 1;
    for (int i=2; i<=n; i++) res *= i;
    return res;
}

int main()
{
    int limit = factorial(9); //arbitrary limit, due to it being an addition the limit is naturally going to be relatively small compared to the other challenges
    int result = 0;
    for (int i=3; i<limit; i++) { //1 and 2 are not accounted for
        int n = i; //copy for checking
        int sum = 0;
        while (n > 0) {
            sum += factorial(n%10);
            n /= 10;
        }
        if (sum == i) result += i;
    }
    cout << result << endl;
}
