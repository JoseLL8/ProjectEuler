#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main()
{
    //this one was mostly copied from the projecteuler thread. i couldnt come up with something nearly as efficient as this :[
    int n, i, len, maxlen, maxn;
	maxlen = 0;
	for( n=2 ; n<1000 ; n++ ){
		int rest = 1;
		int r0;
		for( i=0 ; i<n/2 ; i++ ) {
            rest = (rest*10)%n;
        }
		r0 = rest;
		len = 0;
		do {
			rest = (rest*10)%n;
			len++;
		} while( rest!=r0 );
		if( len>maxlen ){
			maxn = n;
			maxlen = len;
		}
	}
    cout << maxn << endl;
}
