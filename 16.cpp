#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector<int> numbers = {1};
    int target = 3;
    for (int i = 1; i <= target; i++) {
        for (vector<int>::iterator n = numbers.begin(); n < numbers.end(); n++) {
            *n *= 2;
        }
    }
    for (auto n : numbers) {
        cout << n;
    }
    cout << endl;
}
