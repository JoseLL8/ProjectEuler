#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int countFactors(int n, vector<int> primes) {
    int count;
    int result = 1; //1 is always a factor
    for (auto p : primes) {
        count = 1;
        while (!(n%p)) {
            n /= p;
            count++;
        }
        result *= count;
        if (n==1) return result; //done, no more factors
    }
    return result;
}

int main()
{
    int limit = 100000;
    vector<int> primes = {2}; //reusing solution from 7 to generate primes
    int i = 3;
    bool isPrime;
    while (i < limit) { //since we are looking for factors, we probably dont need as many primes
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
    vector<int> triangles = {1};
    for (int i=2; i<limit; i++) {
        triangles.push_back(*triangles.rbegin()+i);
    }
    int result = 0;
    for (auto t : triangles) {
        if (countFactors(t, primes) > 500) {
            result = t;
            break; //stop at first hit
        }
    }
    cout << result << endl;
}
