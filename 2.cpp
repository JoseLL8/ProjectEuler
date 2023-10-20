#include <iostream>

using namespace std;

int main()
{
    int limit = 4000000;
    int a = 2;
    int b = 0;
    int aux;
    int sum = 0;
    while (a < limit) {
        sum += a;
        aux = a;
        a = a*4 + b;
        b = aux;
    }
    cout << sum << endl;
}
