#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int limit = 20;
    vector<int> base;
    for (int i=2; i<=limit; i++) {
        base.push_back(i);
    }
    for (vector<int>::iterator i = base.begin()+1; i < base.end(); i++) { //start at second number
        for (vector<int>::iterator j = base.begin(); j < i; j++) {
            if (!(*i % *j)) { //if a number of the vector can be divided by a previous entry in the vector, it is divided
                *i /= *j; //this way the number is the smallest possible (for example, instead of multiplying 2*4, we divide 4 by 2 and then multiply 2*2 to find the biggest number that is divisible by both 2 and 4)
            }
        }
    }
    int result = 1;
    for (auto i : base) {
        result *= i; //the result is the product of all the numbers reduced to their factors in the previous step
    }
    cout << result << endl;
}
