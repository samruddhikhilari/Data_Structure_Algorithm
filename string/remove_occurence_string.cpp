#include <iostream>
#include <string>
using namespace std;
int main()
{
    string str = "edabaabcbcc";
    string sub = "abc";
    int n = str.length();
    cout << str.length();
    while (str.find(sub) < n && n > 0)
    {
        str.erase(str.find(sub), sub.length());
        cout << endl
             << str.length();
        cout << endl
             << str;
    }
    return 0;
}
/*
1. string , substr
2. remove substr's from str
3. return the updated str
*/
