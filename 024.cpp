#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector<int> digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //needs to be sorted
    vector<int> perms;
    int target = 1000000; //desired permutation
    int aux = 1;
    for (int i = 2; i < digits.size(); i++) { //calculate number of permutations per number of available digits
        aux *= i;
        perms.push_back(aux);
    }

    vector<int> answer;
    int p = perms.size() - 1; //the position of the digit we are currently looking to fill in
    int index = 0; //the digit we are currently considering
    while (p >= 0) { //stop when all digits have been assigned
        if (target > perms[p]) { //target permutation is too big for using the digit from index, we move on to the next one
            target -= perms[p];
            index++;
        }
        else { //found a position for this digit, push it in and move on the next one
            p--;
            answer.push_back(digits[index]);
            digits.erase(digits.begin()+index); //no repeats, delete the used digit
            index = 0;
        }
    }
    for (int d : answer) {
        cout << d;
    }
    cout << digits[target] << digits[1-target] << endl; //the last 2 digits depend on the remaining value of target being 1 or 0
}
