#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool checkUniqueDigits(string n) { //modified from problem thread 32, kevingong. this version uses strings and only checks if any digits are repeated
    int ref = 0;
    for (char d : n) {
        int digit = d-'0';
        if (ref & (1 << (digit))) return false; //digit already found
        ref |= (1 << (digit)); //flip bit corresponding to the digit
    }
    return true;
}

int main()
{
    vector<string> hits;
    int factors[] = {13, 11, 7, 5, 3, 2}; //17 not included as it is used to generate the first batch of candidates

    for (int k=17; k<1000; k+=17) {
        string ks = to_string(k);
        if (k<100) ks = "0"+ks;
        if (checkUniqueDigits(ks)) hits.push_back(ks);
    }

    for (int f=0; f<sizeof(factors)/sizeof(int); f++) {
        int limit = hits.size(); //this part signals where the candidates for this iteration end and the ones for the next begin
        for (int i=0; i<limit; i++) {
            for (int d=0; d<10; d++) {
                string aux = to_string(d)+hits[i];
                if (checkUniqueDigits(aux)) { //first the faster check
                    if (!(stoi(aux.substr(0, 3))%factors[f])) {
                        hits.push_back(aux);
                    }
                }
            }
        }
        hits.erase(hits.begin(), hits.begin()+limit); //delete candidates from this iteration, move on to the next
    }

    for (int i=0; i<hits.size(); i++) { //one all conditions have been met, each candidate is still missing one digit
        for (int d=0; d<10; d++) {
            string aux = to_string(d)+hits[i];
            if (checkUniqueDigits(aux)) { //they should be pandigital
                hits[i] = aux;
                break;
            }
        }
    }

    long long int result = 0;
    for (string k : hits) 
    result += stoll(k);
    cout << result << endl;
    /*for (int i=0; i<hits.size(); i++) {
        for (int d=0; d<10; d++) {
            string aux = to_string(d)+hits[i];
            if (checkUniqueDigits(aux)) {
                if (!(stoi(aux.substr(0, 3))%13)) {
                    hits[i] = aux;
                    break;
                }
            }
        }
        if (hits[i].length() < 4) {
            hits.erase(hits.begin()+i);
            i--;
        }
    }

    for (int i=0; i<hits.size(); i++) {
        for (int d=0; d<10; d++) {
            string aux = to_string(d)+hits[i];
            if (checkUniqueDigits(aux)) {
                if (!(stoi(aux.substr(0, 3))%11)) {
                    hits[i] = aux;
                    break;
                }
            }
        }
        if (hits[i].length() < 5) {
            hits.erase(hits.begin()+i);
            i--;
        }
    }

    for (int i=0; i<hits.size(); i++) {
        for (int d=0; d<10; d++) {
            string aux = to_string(d)+hits[i];
            if (checkUniqueDigits(aux)) {
                if (!(stoi(aux.substr(0, 3))%7)) {
                    hits[i] = aux;
                    break;
                }
            }
        }
        if (hits[i].length() < 6) {
            hits.erase(hits.begin()+i);
            i--;
        }
    }

    for (int i=0; i<hits.size(); i++) {
        for (int d=0; d<10; d++) {
            string aux = to_string(d)+hits[i];
            if (checkUniqueDigits(aux)) {
                if (!(stoi(aux.substr(0, 3))%5)) {
                    hits.push_back(aux);
                    //break;
                }
            }
        }
        if (hits[i].length() < 7) {
            hits.erase(hits.begin()+i);
            i--;
        }
    }

    for (int i=0; i<hits.size(); i++) {
        for (int d=0; d<10; d++) {
            string aux = to_string(d)+hits[i];
            if (checkUniqueDigits(aux)) {
                if (!(stoi(aux.substr(0, 3))%3)) {
                    hits[i] = aux;
                    break;
                }
            }
        }
        if (hits[i].length() < 8) {
            hits.erase(hits.begin()+i);
            i--;
        }
    }

    for (int i=0; i<hits.size(); i++) {
        for (int d=0; d<10; d++) {
            string aux = to_string(d)+hits[i];
            if (checkUniqueDigits(aux)) {
                if (!(stoi(aux.substr(0, 3))%2)) {
                    hits.push_back(aux);
                    //break;
                }
            }
        }
        if (hits[i].length() < 9) {
            hits.erase(hits.begin()+i);
            i--;
        }
    }

    for (int i=0; i<hits.size(); i++) {
        for (int d=0; d<10; d++) {
            string aux = to_string(d)+hits[i];
            if (checkUniqueDigits(aux)) {
                hits[i] = aux;
                break;
            }
        }
    }*/
}
