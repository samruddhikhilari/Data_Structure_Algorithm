#include <iostream>
#include <string>
using namespace std;
int main()
{
    string str;
    cout << "enter a string to check pallindrome" << endl;
    cin >> str;
    int n = str.length();
    int i = 0, j = n - 1;
    bool flag = true;
    while (i < j)
    {
        if (str[i] != str[j])
        {
            flag = false;
            break;
        }
        i++, j--;
    }
    if (flag)
        cout << "pallindrome";
    else
        cout << "not pallindrome";

    return 0;
}