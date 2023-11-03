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
    int target = 2; //number of digits
    vector<int> primes = genPrimes(pow(10, target));

    for (int d=1; d<target; d++) { //d is the number of digits that are fixed, target - d are the digits that will be replaced by other values in order to find digits
        for (int i=0; i<pow(10,d); i++) { //i is the fixed number (in the examples from the problem it would be *3 (3), or 56**3 (563))
            //here is something missing to determine what digit positions are going to be used. in an example with 2 digits, we would need to determine whether we are checking ix or xi. this gets more complicated with more digits
            for (int x=0; x<10; x++) { //x is the variable digit used to find different primes
                //???
            }
        }
    }
}
