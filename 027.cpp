#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

vector<int> genPrimes(int limit) { //reusing challenge 7
    vector<int> primes = {2};
    bool isPrime;
    for (int i = 3; i < limit; i+=2) {
        isPrime = true;
        for (auto p : primes) { 
            if (!(i%p)) {
                isPrime = false;
                break;
            }
            else if (p > sqrt(i)) break;
        }
        if (isPrime) primes.push_back(i);
    }
    return primes;
}

int main()
{
    int limit = 1000;
    vector<int> primes = genPrimes(limit);

    int max = 0;
    int result;
    for (int b = 0; primes[b] <= limit; b++) { //because the sequence starts at n=0, the first prime is 0^2+a0+b, so b is always prime
        for (int a = -limit+1; a < limit; a+=2) { //for n=1, our prime is 1+a+b. considering b is a prime (and most likely odd), a needs to be odd too in order to give a prime in this case, so a can only be odd
            int n; //broaden scope of n
            for (n = 0; binary_search(primes.begin(), primes.end(), n*(n+a)-primes[b]); n++) {} //count number of consecutive primes with -b
            if (n > max) {
                max = n;
                result = -primes[b]*a;
                //cout << "New max " << max << " with a=" << a << " and b=" << -primes[b] << endl;
            }
            for (n = 0; binary_search(primes.begin(), primes.end(), n*(n+a)+primes[b]); n++) {} //count with +b
            if (n > max) {
                max = n;
                result = primes[b]*a;
                //cout << "New max " << max << " with a=" << a << " and b=" << primes[b] << endl;
            }
        }
    }
    cout << result << endl;
}
