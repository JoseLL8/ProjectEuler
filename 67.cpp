#include <iostream>
#include <string>
#include <vector>
#include <fstream>
std::ifstream infile("p067_triangle.txt");

using namespace std;

int main()
{
    int size = 100;
    vector<vector <int> > pyramid (size);
    int sums[size] = {0};
    string line;
    int row = 0;
    while (getline(infile, line)) {
        for (int i = 0; i < line.length(); i+=3) {
            pyramid[row].push_back(stoi(line.substr(i, 3)));
        }
        row++;
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
