#include <iostream>

using namespace std;

int main()
{
    int limit = 100;
    int sum = limit * (limit+1) / 2;
    int square_sum = (2*limit+1)*(limit+1)*limit/6;
    cout << sum*sum-square_sum << endl;
}
