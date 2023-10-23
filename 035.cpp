#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <set>

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
    int limit = 1000000;
    vector<int> primes = genPrimes(limit);
    set<int> hits;

    for (int p : primes) {
        if (binary_search(hits.begin(), hits.end(), p)) continue; //rotation of a previous number, already added so we can skip
        bool valid = true;
        set<int> local_hits = {p};
        int power = log10(p); //this is wasted on p>10, but its only the first 4 cases so its fine
        for (int i=0; i<power; i++) {//each number rotates a number of times equal to their number of digits - 1
            int aux = p%10;
            p /= 10;
            p += aux * pow(10, power);
            if (!binary_search(primes.begin(), primes.end(), p)) {
                valid = false; //one of the rotations is not a prime
                break;
            }
            local_hits.insert(p); //store rotation in case p is a circular prime
        }
        if (valid) {
            hits.merge(local_hits); //add all rotations
        }
    }
    cout << hits.size() << endl;
}
