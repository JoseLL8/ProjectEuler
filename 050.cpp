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
    int limit = 1000000;
    vector<int> primes = genPrimes(limit);
    int result, max = 0;
    for (int prev = 0; prev<primes.size(); prev++) {
        long int sum = primes[prev];
        int count = 1;
        if (prev == 1) {
            cout << "";
        }
        for (int p = prev+1; p<primes.size(); p++) {
            sum += primes[p];
            count++;
            if (sum > limit) break;
            if (count>max) { //overwrite for the biggest sequence yet
                if (binary_search(primes.begin(), primes.end(), sum)) { //this is the more costly check, we only do it if the sequence is the longest so far
                    result = sum;
                    max = count;
                }
            }
        }
    }
    cout << result << endl;
}
