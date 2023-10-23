#include <iostream>

using namespace std;

int main()
{
    int target = 200;
    int coins[] = {1, 2, 5, 10, 20, 50, 100, 200};
    int ways[target+1];
    ways[0] = 1;
    for (int coin : coins) {
        for (int j = coin; j <= target; j++) {
            ways[j] += ways[j-coin];
        }
    }
    cout << ways[target-1] << endl;
}
