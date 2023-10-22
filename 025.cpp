#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    long double target = 1000; //number of digits
    long double ref = pow(10, target-1); //smallest number with desired number of digits
    float gold_ratio = (1+sqrt(5)) / 2;
    int result = ceil(log10(ref*sqrt(5)) / log10(gold_ratio)); //this uses a formula from wikipedia for finding the index of a fibonacci number. we can simply use this formula on the smallest number with the required digits, and round up the result
    cout << result << endl; //source for the formula: https://en.wikipedia.org/wiki/Fibonacci_number#Computation_by_rounding
}
