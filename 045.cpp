#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    //in my first attempt i already optimized by skipping checking for triangular numbers (as all of them are also hexagonal) and only using hexagonal and pentagonal numbers
    //now i am also using an optimization from euler on the problem thread, generating only hexagonal numbers and checking them against a formula for verifying pentagonals
    for (int i=2; true; i++) {
        long long int h = i*(2*i-1); //hexagonal number
        if (h==40755) continue; //skip, we want the next one
        //the next formula is taken from the formula for a pentagonal number n: P = (n*(3n-1))/2; -> 3n^2-n-2P=0; -> n = (1+sqrt(1+24P))/6; from the quadratic formula
        //we take the positive root because we are only evaluating positiven numbers
        double k = (1+sqrt(1+24*h))/6;
        if (k == (int)k) { //k has no decimals, so h produces an integer in the previous formula, meaning h is also pentagonal
            cout << h << endl;
            break; //done
        }
    }
}
