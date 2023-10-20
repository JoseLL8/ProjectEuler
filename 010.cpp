#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main()
{
    int limit = 2000000;
    vector<int> primes = {2};

    int i = 3;
    bool isPrime;
    while (i < limit) {
        isPrime = true;
        for (auto p : primes) { //reusing challenge 7
            if (!(i%p)) {
                isPrime = false;
                break;
            }
            else if (p > sqrt(i)) break;
        }
        if (isPrime) primes.push_back(i);
        i += 2; //this could be optimized
    }

    long int sum = 0;
    for (auto p : primes) {
        sum += p;
    }
    cout << sum << endl;
}
