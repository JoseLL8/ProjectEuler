#include <iostream>
#include <string>

using namespace std;

int digit(int n, int index) { //returns digit in the index position of the number n, the first digit on the left being 0
    return to_string(n)[index]-'0';
}

int main()
{
    int result = 1;
    int next = 1; //points when the number of digits per number changes
    int target = 1;
    int limit = 1000000;
    int step = 0; //depends on the number of digits
    int index = 1; //because the only the decimals are counted, d1 is 1, not 0, we start at 1

    for (int i=1; index<=limit; i++) {
        index += step;
        if (index>=target) {
            result *= digit(i, index-target); //get the correct digit
            target *= 10; //the powers of 10 are the indexes we are seeking
        }
        if (i>=next) {
            step++;
            next *= 10;
        }
    }
    cout << result << endl;
}
