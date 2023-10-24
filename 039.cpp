#include <iostream>
#include <numeric>
#include <set>

using namespace std;

int main()
{
    //reusing stuff from problem 9
    //a=m^2-n^2, b=2mn, c=m^2+n^2, m>n>0
    int limit = 1000;
    set<int> used;
    int hits[limit] = {0}; //number of solutions for each value of p. there is a lot of wasted space here, but it is affordable for a limit of 1000
    int m;
    int n = 1;
    for (m = 2; n < limit/10; m++) { //arbitrary limit
        if (gcd(m, n) > 1) continue; //m and n should be coprime
        int p = 2*m*m+2*m*n;

        //if m and n are coprime but also odd, then the usual formula will not result in a primitive triplet. halving the triplet numbers will, however (for example, for m=5, n=1 the triplet (24, 10, 26), which is not primitive, but (12, 5, 13) is, however)
        //these primitives from halving the terms can be unique or not, the previous primitive triplet can only be obtained for those values of m and n specifically, but (3, 4, 5) can be obtained with m=2, n=1 as well as m=3, n=1 by halving the triplet
        if ((m%2&&n%2)) { //if both are odd
            p /= 2;
        }
        if (!used.insert(p).second) { //insert failed, element exists already. we use the perimeter as an identifier for primitive triplets, since it is unique to each one (i think, i couldnt find proof)
            continue;
        }

        for (int aux=p; aux<=limit; aux+=p) {
            hits[aux-1]++;
        }
        if (2*m*m + 2*m > limit) { //m is the main component of the addition, if it gets too big we should increase n instead
            n++;
            m=n+1; //here we ensure that m and n are always of different parity (and in the for loop increase step as well)
        }
    }

    int result = 0;
    int max = 0;
    for (int i = 0; i<limit; i++) {
        if (hits[i] > max) {
            result = i+1;
            max = hits[i];
        }
    }
    cout << result;
}
