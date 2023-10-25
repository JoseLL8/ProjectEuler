#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <fstream>
std::ifstream infile("p042_words.txt");

using namespace std;

vector<int> genTriangleSequence(int limit) {
    vector<int> result;
    int n = 0;
    for (int i=1; n<limit; i++) {
        n += i;
        result.push_back(n);
    }
    return result;
}

int main()
{
    //very similar problem to 22
    vector<string> words;
    string line;
    if (getline(infile, line)) {
        int bookmark = 1;
        for (int i = 2; i < line.length(); i++) {
            if (line[i] == ',') {
                //cout << line.substr(bookmark, i-bookmark-1) << endl;
                words.push_back(line.substr(bookmark, i-bookmark-1));
                i+=2;
                bookmark = i;
            }
        }
        //cout << line.substr(bookmark, line.length()-bookmark-1) << endl;
        words.push_back(line.substr(bookmark, line.length()-bookmark-1));
    }

    vector<int> triangles = genTriangleSequence(1000); //we could check for every word, but here we generate the sequence ahead of time and then look up the values
    int hits = 0;
    for (string word : words) {
        int value = 0;
        for (char c : word) value += c-'A'+1; //'A' is position 1
        if (binary_search(triangles.begin(), triangles.end(), value)) { //triangle word found
            //cout << word << endl;
            hits++;
        }
    }
    cout << hits << endl;
}
