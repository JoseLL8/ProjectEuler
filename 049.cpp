#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <string>

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

bool checkPerm(int n1, int n2) { //checks if n1 and n2 are permutations of one another. i used string, probably not very efficient
    string s1 = to_string(n1);
    sort(s1.begin(), s1.end());
    string s2 = to_string(n2);
    sort(s2.begin(), s2.end());
    return s1==s2;
}

int main()
{
    //i didnt realize that the sequence we are looking for also has a step of 3330, so i implemented to work without that assumption, which makes it slower than it should be
    vector<int> primes = genPrimes(10000); //the problem specifies 4-digit numbers
    for (vector<int>::iterator prev = primes.begin(); prev<primes.end(); prev++) {
        if (*prev<1000 || *prev==1487) continue; //skip less than 4 digits and the example from the problem description
        for (vector<int>::iterator p = prev+1; p<primes.end(); p++) {
            if (!checkPerm(*p, *prev)) continue;
            int post = 2**p-*prev;
            if (checkPerm(*p, post) && binary_search(primes.begin(), primes.end(), post)) { //adding the difference between p and prev to p generates another prime
                cout << *prev << *p << post << endl;
                goto exit; //nested for, cant just break
            }
        }
    }
    exit: ;
}
