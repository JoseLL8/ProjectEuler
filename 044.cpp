#include <iostream>
#include <chrono>

#include <vector>
#include <algorithm>

using namespace std;

vector<int> genPentagonSequence(int limit) {
    vector<int> result;
    int prev = 1;
    for (int i=2; prev<limit; i++) {
        result.push_back(prev);
        prev += 3*i-2;
    }
    return result;
}

int main()
{
    std::chrono::steady_clock::time_point begin = std::chrono::steady_clock::now();

    int limit = 10000000;
    //i could have also used an array[limit] of bools, i think either would have worked fine. in the array more time is spent iterating through it, while the vector cannot lookup elements so easily
    //this implementation is a little slow (~3s) but it works fine for this case i guess
    vector<int> pentagons = genPentagonSequence(limit);
    int min = limit; //looking for the smallest difference
    for (vector<int>::iterator p1 = pentagons.begin(); p1 < pentagons.end(); p1++) {
        for (vector<int>::iterator p2 = pentagons.begin(); p2 < p1; p2++) {
            int diff = *p1-*p2; //calculated here to not repeat calculations later
            if (binary_search(pentagons.begin(), pentagons.end(), *p1+*p2) && binary_search(pentagons.begin(), pentagons.end(), diff) && diff<min) min = diff;
        }
    }
    cout << min << endl;

    std::chrono::steady_clock::time_point end = std::chrono::steady_clock::now();
    std::cout << "Time difference = " << std::chrono::duration_cast<std::chrono::microseconds>(end - begin).count() << "[µs]" << std::endl;
    std::cout << "Time difference = " << std::chrono::duration_cast<std::chrono::nanoseconds> (end - begin).count() << "[ns]" << std::endl;
}
