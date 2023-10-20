#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main()
{
    int target = 10001;
    vector<int> primes = {2};

    int i = 3;
    bool isPrime;
    while (primes.size() < target) {
        isPrime = true;
        for (auto p : primes) { //we iterate over the vector itself using previous elements to find new ones to insert
            if (!(i%p)) {
                isPrime = false;
                break;
            }
            else if (p > sqrt(i)) break;
        }
        if (isPrime) primes.push_back(i);
        i += 2; //this could be optimized
    }
    cout << *primes.rbegin() << endl;
}
