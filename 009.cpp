#include <iostream>

using namespace std;

int main()
{
    int target = 1000;
    //euclid's formula is used for finding pythagorean triplets, and is the following:
    //a=m^2-n^2, b=2mn, c=m^2+n^2, m>n>0
    //using this formula it is much faster to search for a valid solution
    int m = 2;
    int n = 1;
    //while (2*m*m+2*m*n != target) { //a+b+c=2m^2+2mn, this condition also works but is suboptimal
    while (target % (2*m*m+2*m*n)) { //new triplets can be found from multiplying existing ones with positive natural numbers (if a,b,c is a triplet, then ka,kb,kc is also a triplet). using this condition we find the first triplet that adds up to a factor of the target, and then find the value of k
        m++;
        if (2*m*m + 2*m > target) { //m is the main component of the addition, if it gets too big we should increase n instead
            m = n+2;
            n++;
        }
    }
    int k = target / (2*m*m+2*m*n);
    //cout << k << " " << m << " " << n << endl;
    cout << k*k*k*(m*m-n*n)*2*m*n*(m*m+n*n) << endl;
}
