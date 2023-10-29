#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

int main()
{
    vector<int> hits;
    //we are looking for fractions of the form ax/xb or xa/bx == a/b (these forms representing digits, not multiplications) where a, b, x>0 and a/b 1
    for (float a=1; a<9; a++) {
        for (float b=a+1; b<10; b++) { //because the fractions are >1, b always starts bigger than a, so no need to check
            for (float x=1; x<10; x++) {
                if ((x*10+a)/(b*10+x) == a/b || (a*10+x)/(x*10+b) == a/b) { //no fractions are found with the first condition, but i left it as is
                    hits.push_back(a);
                    hits.push_back(b);
                }
            }
        }
    }
    int a = 1;
    int b = 1;
    for (int i = 0; i < hits.size(); i+=2) { //multiply all fractions
        a *= hits[i];
        b *= hits[i+1];
    }
    cout << b/gcd(a, b) << endl; //result is the denominator of the simplified product of all fractions
}
