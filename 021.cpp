#include <iostream>

using namespace std;

int sumFactors(int n) {
    int result = 1;
    int p = 2;
    int org = n;
    while (p*p<=n && n>1) {
        if (!(n%p)) {
            int j = p * p;
            n /= p;
            while (!(n%p)) {
                j *= p;
                n /= p;
            }
            result *= (j-1);
            result /= (p-1);
        }
        if (p==2) p=3; else p+=2;
    }
    if (n>1) result *= n+1;
    return result - org;
}

int main()
{
    int limit = 10000;
    int sum = 0;
    for (int a = 2; a < limit; a++) {
        int b = sumFactors(a);
        if (b > a) {
            if (a == sumFactors(b)) sum += a+b;
        }
    }
    cout << sum << endl;
}
