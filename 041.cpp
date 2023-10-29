#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

bool checkPandigital(int n) { //using modified optimization from problem thread 32, from kevingong
    int result = 0;
    int ref = 0;
    while (n > 0) {
        int digit = n%10;
        if (!digit) return false; //0 cant be in a pandigital
        if (result & (1 << (digit-1))) return false; //digit already found
        result |= (1 << (digit-1)); //flip bit corresponding to the digit
        n /= 10;
        ref = (ref << 1) + 1;
    }
    if (result == ref) return true; //all digits found , so it is equal to ref, which should have a number of 1s equal to the digits
    return false;
}

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
    //this challenge is pretty simple, we just leverage 2 functions from previous challenges
    int limit = 10000000; //arbitrary, the number we seek is 7652413
    vector<int> primes = genPrimes(limit);
    for (vector<int>::reverse_iterator i = primes.rbegin(); i<primes.rend(); i++) {
        if (checkPandigital(*i)) {
            cout << *i << endl;
            break;
        }
    }
}
