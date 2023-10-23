#include <iostream>
#include <set>

using namespace std;

bool checkPandigital(int (*n_array)[3]) {
    bool checks[9] = {false}; //tracking each digit
    for (int n : *n_array) {
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            if (!d) return false; //pandigitals dont have 0
            if (checks[d-1]) return false; //digit appeared twice
            checks[d-1] = true;
        }
    }
    for (bool check : checks) {
        if (!check) return false;
    }
    return true;
}

int main()
{
    set<int> hits; //no repeats
    for (int a = 2; a < 100; a++) {
        for (int b = 100; b < 2000; b++) {
            int candidate[3] = {a, b, a*b};
            if (checkPandigital(&candidate)) {
                hits.insert(a*b);
                //cout << a << "*" << b << "=" << a*b << endl;
            }
        }
    }
    int result = 0;
    for (int h : hits) {
        result += h;
    }
    cout << result << endl;
}
