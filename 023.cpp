#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int sumFactors(int n) {
    int result = 1;
    int p = 2;
    int org = n;
    while (p*p<=n && n>1) {
        if (!(n%p)) {
            int j = p * p;
            n /= p;
            while (!(n%p)) {
                j *= p;
                n /= p;
            }
            result *= (j-1);
            result /= (p-1);
        }
        if (p==2) p=3; else p+=2;
    }
    if (n>1) result *= n+1;
    return result - org;
}

int main()
{
    int limit = 28123;
    vector<int> abundantNumbers;
    for (int i = 2; i <= limit; i++) {
        if (sumFactors(i) > i) {
            abundantNumbers.push_back(i); //find all abundant numbers below the limit
        }
    }
    bool isAbundantSum[limit*2+1] = {false}; //allocating extra space is faster than checking if we are out of bounds
    for (int i = 0; i < abundantNumbers.size(); i++) {
        for (int j = 0; j <= i; j++) {
            isAbundantSum[abundantNumbers[i]+abundantNumbers[j]] = true; //mark all the numbers that are additions
        }
    }
    int result = 0;
    for (int k = 0; k < limit; k++) {
        if (!isAbundantSum[k]) result += k; //add unmarked numbers
    }
    cout << result << endl;
}
