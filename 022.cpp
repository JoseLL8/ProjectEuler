#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <fstream>
std::ifstream infile("p022_names.txt");

using namespace std;

int main()
{
    vector<string> names;
    string line;
    if (getline(infile, line)) {
        int bookmark = 1;
        for (int i = 2; i < line.length(); i++) {
            if (line[i] == ',') {
                //cout << line.substr(bookmark, i-bookmark-2) << endl;
                names.push_back(line.substr(bookmark, i-bookmark-1));
                i+=2;
                bookmark = i;
            }
        }
        //cout << line.substr(bookmark, line.length()-bookmark-1) << endl;
        names.push_back(line.substr(bookmark, line.length()-bookmark-1));
    }
    sort(names.begin(), names.end());

    long int sum = 0;
    int value;
    for (int i = 1; i <= names.size(); i++) {
        value = 0;
        for (char c : names[i-1]) {
            value += c-'A'+1; //all names are in caps and 'A' is the first position
        }
        sum += value*i;
    }
    cout << sum << endl;
}
