#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    string number = "1"; //using a string to store big numbers, like in 16
    int target = 100;
    int aux;
    for (int i = 2; i <= target; i++) {
        int co = 0; //carryover, here it can have more than 1 digit
        for (char& c : number) {
            aux = i*(c-'0')+co;
            co = aux/10;
            c = '0'+aux%10;
        }
        while (co) {
            number.push_back(co%10+'0'); //the duplication finished and carryover is not 0, so we add a new digit
            co /= 10;
        }
    }
    //reverse(number.begin(), number.end()); //the number is backwards when finished, though this doesnt affect the result
    //cout << number << endl;
    int sum = 0;
    for (char& c : number) {
        sum += c-'0';
    }
    cout << sum << endl;
}
