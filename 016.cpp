#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    string number = "1"; //using a string to store big numbers
    int target = 1000;
    for (int i = 1; i <= target; i++) {
        int co = 0; //carryover
        int aux;
        for (char& c : number) {
            aux = 2*(c-'0')+co;
            co = aux/10;
            c = '0'+aux%10;
        }
        if (co) number.push_back(co+'0'); //the duplication finished and carryover is not 0, so we add a new digit
    }
    reverse(number.begin(), number.end()); //the number is backwards when finished, though this doesnt affect the result
    int sum = 0;
    for (char& c : number) {
        sum += c-'0';
    }
    cout << sum << endl;
}
