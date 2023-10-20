#include <iostream>
#include <vector>

using namespace std;

vector<int> memory = {1};

int collatz(long int n) {
    if (n <= memory.size()) {
        return memory[n-1]; //use previous value to shorten calculations
    }
    if (n%2) {
        return 1 + collatz((n*3 + 1));
    }
    else {
        return 1 + collatz(n/2);
    }
}

int main()
{
    int target = 1000000;
    int aux;
    int max = 0;
    int result;

    for (long int i = 2; i < target; i++) {
        aux = collatz(i);
        //cout << i << " " << aux << endl;
        memory.push_back(aux); //store value for future calculations (the values close to target value are probably not necessary)
        if (aux > max) {
            max = aux;
            result = i;
        }
    }
    cout << result << endl;
}
