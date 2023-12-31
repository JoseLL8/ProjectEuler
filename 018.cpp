#include <iostream>
#include <string>
#include <vector>

using namespace std;
string in = "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 99 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

int main()
{
    int size = 15;
    vector<vector <int> > pyramid (size);
    int sums[size] = {0};
    int row = 0;
    int count = -1;
    for (int i = 0; i < in.length(); i+=3) {
        count++;
        pyramid[row].push_back(stoi(in.substr(i, 3)));
        if (count==row) {
            row++;
            count=-1;
        }
    }
    for (int r = 1; r < size; r++) {
        for (int i = 0; i < pyramid[r].size(); i++) { //using dynamic programming, we calculate the maximum sum per row taking into account the previous values
            if (!i) pyramid[r][i] += pyramid[r-1][i]; //on the left edge there is only one option
            else if (i == pyramid[r].size()-1) pyramid[r][i] += pyramid[r-1][i-1]; //same for the right edge
            else if (pyramid[r-1][i-1] > pyramid[r-1][i]) pyramid[r][i] += pyramid[r-1][i-1];
            else pyramid[r][i] += pyramid[r-1][i];
        }
    }
    int max = 0;
    for (auto i : pyramid[size-1]) { //result is max value of the last row
        if (i > max) max = i;
    }
    cout << max << endl;
}
