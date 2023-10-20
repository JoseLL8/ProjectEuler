#include <iostream>

using namespace std;

int sumMultiples(int limit, int base) {
    int p = (limit-1)/base; //the number of elements in the sum, we only count up to limit-1 (999 in this case) as the limit itself is not included
    return base * p * (p+1) / 2; //p * (p+1) / 2 is equal to 1+2+...+p, and that times base is the result
}

int main()
{
    int limit = 1000;
    cout << sumMultiples(limit, 3) + sumMultiples(limit, 5) - sumMultiples(limit, 15) << endl; //multiples of 3 and 5 overlap in the multiples of 3*5, that is 15

}
