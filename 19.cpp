#include <iostream>
#include <vector>

using namespace std;

vector<int> months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //days per month

int main()
{
    int year = 1901;
    int month = 0;
    int day = 6; //using this program i calculated 06/01/1901 to be the first sunday of 1901
    int count = 0;
    while (year < 2001) {//stop at 2001
        day += 7;
		if ((month!=1 || year%4!=0 || (year%100==0 && year%400!=0)) && day>months[month]) {day -= months[month]; month++;} //regular month
		else if (month==1 && year%4==0 && (year%100!=0 || year%400==0) && day>29) { day -= 29; month++;} //february in leap year
		if (month > 11) {month = 0; year++;}
		if (day==1) {count++;}
    }
    cout << count << endl;
}
