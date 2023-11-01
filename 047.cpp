#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> getFactors(int n) {
    vector<int> result;
    int p = 2;
    while (p<=n && n>1) {
        if (!(n%p)) {
            int j = p;
            n /= p;
            while (!(n%p)) { //we need both the prime itself and its power
                j *= p;
                n /= p;
            }
            result.push_back(j);
        }
        if (p==2) p=3; else p+=2;
    }
    return result;
}

int main()
{
    int target = 4;
    vector<vector <int> > hits;
    for (int i = 1;  hits.size()<target; i++) {
        vector<int> factors = getFactors(i);
        if (factors.size()!=target) {
            hits.clear();
            continue; //only looking for sequence with same number of factors
        }
        for (vector<int> n : hits) { //check the previous elements of the sequence
            vector<int> aux;
            set_intersection(factors.begin(), factors.end(), n.begin(), n.end(), back_inserter(aux));
            if (aux.size()>0) { //some factors are shared, meaning this sequence is not valid
                hits.clear();
                break;
            }
        }
        hits.push_back(factors); //even if the previous sequence was invalid, the current number may still be part of a valid one, so we reinsert it regardless
    }
    int result = 1;
    for (int i : hits[0]) { //the result is the first element of the sequence
        result *= i;
    }
    cout << result << endl;
}