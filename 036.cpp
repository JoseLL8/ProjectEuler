#include <iostream>
#include <string>

using namespace std;

int makePalindrome2(int n, bool oddlength) { //taken from the problem 36 overview
    int result = n;
    if (oddlength) n = n>>1;
    while (n>0) {
        result = (result << 1) + (n&1);
        n = n >> 1;
    }
    return result;
}

bool checkPalindrome(string in) {
    for (int i=0; i<in.length()/2; i++) {
        if (in[i] != in[in.length()-1-i]) return false;
    }
    return true;
}

int main()
{
    int limit = 1000000;
    int result = 0;

    int pal = makePalindrome2(1, false);
    for (int i = 2; pal < limit; i++) {
        if (checkPalindrome(to_string(pal)))  result += pal;
        pal = makePalindrome2(i, false);
    }
    pal = makePalindrome2(1, true);
    for (int i = 2; pal < limit; i++) {
        if (checkPalindrome(to_string(pal)))  result += pal;
        pal = makePalindrome2(i, true);
    }
    cout << result << endl;
}
