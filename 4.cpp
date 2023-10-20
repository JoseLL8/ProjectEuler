#include <iostream>
#include <string>

using namespace std;

bool checkPalindrome(string in) {
    for (int i=0; i<in.length()/2; i++) {
        if (in[i] != in[in.length()-1-i]) return false;
    }
    return true;
}

int main()
{
    int a = 999; //start at the top for finding bigger numbers earlier
    int b;
    int max = 0;

    while (a > 99) { //3 digits only
        b = a;
        while (b > 99) {
            if (checkPalindrome(to_string(a*b)) && a*b > max) { //if smaller than current max, discard
                max = a*b;
            }
            b--;
        }
        a--;
    }
    cout << max << endl;
}
