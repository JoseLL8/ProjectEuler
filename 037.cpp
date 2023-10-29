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
    int limit = 800000; //out of the eleven numbers we are looking for, only one is above 4000, that is 739397
    vector<int> primes = genPrimes(limit);
    set<int> hits;
    int max = 11; //number given by the problem

    for (int p : primes) {
        if (p < 10) continue; //skip 1 digit primes
        if (hits.size() >= max) break; //done
        bool valid = true;
        int copy = p; //copy for inserting
        int power = log10(p); //number of digits
        int digits = power;
        int p2 = p; //copy for checking
        for (int i=0; i<digits; i++) {//each number is trimmed a number of times equal to their number of digits - 1, once to the left and once to the right
            p /= 10; //trimming from the right
            if (!binary_search(primes.begin(), primes.end(), p)) {
                valid = false; //not a prime
                break;
            }
            p2 %= (int)pow(10, power); //trimming from the left
            power--;
            if (!binary_search(primes.begin(), primes.end(), p2)) {
                valid = false; //not a prime
                break;
            }
        }
        if (valid) {
            hits.insert(copy); //add all variations in case its truncatable from left and right
        }
    }
    int result = 0;
    for (int h : hits) {
        //cout << h << endl;
        result += h;
    }
    cout << result << endl;
}
