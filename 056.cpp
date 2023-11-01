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
            aux = n*(c-'0')+co; //this fails when the result is > 100
            co = aux/10;
            c = '0'+aux%10;
        }
        while (co>0) { //modified from 16 to allow greater bases
            number.push_back(co%10+'0');
            co /= 10;
        }
    }
    reverse(number.begin(), number.end()); //the number is backwards when finished, though this doesnt affect the result
    return number;
}

int main()
{
    int max = 0;
    for (int a=2; a<100; a++) { //we probably dont need to start so low, could begin at 80 or 90
        for (int b=1; b<100; b++) { //same here
            string number = slowPower(a, b);
            long int sum = 0;
            for (char& c : number) sum += c-'0';
            if (sum > max) {
                max = sum;
            }
        }
    }
    cout << max << endl;
}
