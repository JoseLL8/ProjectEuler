#include <iostream>
#include <cmath>
#include <set>

using namespace std;

set<int> findFactors(unsigned long int n) {
    set<int> res; //a set contains only unique values
    unsigned long int ref = n;
    while (ref > 1 && ref%2==0) { //the only possible even factor is 2
        res.insert(2);
        ref /= 2;
    }
    int i = 3; //start at 3 and step by 2, since there are no other even primes
    while (i <= sqrt(n) && ref > 1) {
        while (!(ref % i)) {
            res.insert(i);
            ref /= i;
        }
        i += 2;
    }
    return res;
}

int main()
{
    unsigned long int target = 600851475143;
    cout << *findFactors(target).rbegin() << endl; //biggest value is last
}
