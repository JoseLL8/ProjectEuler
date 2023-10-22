#include <iostream>

using namespace std;

int main()
{
    int target = 1001; //size of the spiral
    int prev = 1;
    long int sum = 1;
    for (int i = 2; i < target; i+=2) { //every time you increase the size of the spiral by 2, you add 4 more numbers to the diagonals, that is, another iteration to this loop
        for (int j = 0; j < 4; j++) { //every 4 numbers, their separation distance increases by 2
            prev += i;
            sum += prev;            
        }
    }
    cout << sum << endl;
}
