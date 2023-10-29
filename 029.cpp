#include <iostream>
#include <cmath>
#include <set>

using namespace std;

int main()
{
    int limit = 100;
    set<double> results; //a set does not allow repeats, so we dont have to worry about that
    /*for (double a = 2; a <= limit; a++) {
        for (double b = 2; b <= limit; b++) {
            cout << (double)pow(a, b) << endl;
            results.insert(pow(a, b)); //too big numbers, answer is not right
        }
    }*/
    for (int a = 2; a <= limit; a++) {
        for (int b = 2; b <= limit; b++) { //we dont need the powers themselves, so we use a log for smaller numbers ensuring that we correctly detect duplicates
            //note that used log is base 2, using the increased precision of a computer for operations in base 2. using log with bases like e or 10 will return a wrong answer
            results.insert(a * log2(b));
        }
    }
    cout << results.size() << endl;
}
