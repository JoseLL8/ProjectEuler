#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool checkPandigitalProduct(int n) { //using modified optimization from problem thread 32, from kevingong
    int result = 0;
    int product = n; //start at n*1
    for (int i=2; i<10 && result < 0x1ff; i++) {//usually the loop will end soon before i=9
        while (product > 0) {
            int digit = product%10;
            if (!digit) return false; //0 cant be in an pandigital
            if (result & (1 << (digit-1))) return false; //digit already found
            result |= (1 << (digit-1)); //flip bit corresponding to the digit
            product /= 10;
        }
        product = n*i;
    }
    if (result == 0x1ff) return true; //all digits found , so the first 9 bits are flipped (0xff + 0x100) and nothing else
    return false;
}

int main()
{
    vector<int> hits;
    for (int i=1; i<10000; i++) { //by limiting it to 10000, we dont need to check if the number itself is pandigital already
        if (checkPandigitalProduct(i)) hits.push_back(i);
    }
    string result = "0"; //using strings for easier concatenation
    for (int h : hits) {
        string product = to_string(h);
        for (int i=2; product.length()<9; i++) { //already checked that they were pandigitals, no need to check here
            if (product < result) break; //due to the most significant digits being added first, we dont need to wait for the full product to be calculated in order to check
            product.append(to_string(h*i));
        }
        if (product > result) { //string comparison works fine here, thanks to the digit characters following the same succession as their real values
            result = product;
        }
    }
    cout << result << endl;
}
