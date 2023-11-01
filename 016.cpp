#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string slowPower(int n, int p) { //returns n to the power of p as a string, works for very large numbers
    string number = "1";
    for (int i = 1; i <= p; i++) {
        int co = 0; //carryover
        int aux;
        for (char& c : number) {
            aux = n*(c-'0')+co;
            co = aux/10;
            c = '0'+aux%10;
        }
        if (co) number.push_back(co+'0'); //the duplication finished and carryover is not 0, so we add a new digit
    }
    reverse(number.begin(), number.end()); //the number is backwards when finished, though this doesnt affect the result
    return number;
}

int main()
{
    string number = slowPower(2, 1000);
    //cout << number << endl;
    int sum = 0;
    for (char& c : number) {
        sum += c-'0';
    }
    cout << sum << endl;
}
