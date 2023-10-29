#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

vector<int> genPrimes(int limit) {
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
    int limit = 10000;
    vector<int> primes = genPrimes(limit);
    for (int i=9; i<limit; i+=2) { //start at smallest composite odd number
        if (binary_search(primes.begin(), primes.end(), i)) continue; //prime, not composite
        bool found = true;
        int n = i-2;
        for (int j=2; n>=2; j++) {
            if (binary_search(primes.begin(), primes.end(), n)) { //the number is indeed composite
                found = false;
                break;
            }
            n = i-2*j*j;
        }
        if (found) {
            cout << i << endl;
            break;
        }
    }
}
