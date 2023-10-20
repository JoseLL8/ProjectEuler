#include <iostream>

using namespace std;

int main()
{
    int size = 20;
    long int result = 1;
    for (int i=1; i<=size; i++) {
        result = result*(i+size)/i;
        cout << i << " " << result << endl;
    }
    cout << result << endl;
}
