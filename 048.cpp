#include <iostream>

using namespace std;

int main()
{
    int limit = 1000;
    long long int sum = 0;
    for (int i=1; i<=limit; i++) {
        long long int copy = i;
        for (int e=1; e<i; e++) { //dont want to deal with floats, as we need precision and the later numbers are big
            copy = copy*i%10000000000L; //ignore everything past the first 10 digits
        }
        sum = (sum+copy)%10000000000L; //same here
    }
    cout << sum << endl;
}
