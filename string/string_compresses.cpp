#include <iostream>
#include <string>
using namespace std;
int main()
{
    string str = "aabbcabba";
    int n = str.length();
    int idx = 0;
    cout << str << endl;
    cout << str.length() << endl;
    for (int i = 0; i < n; i++)
    {
        char ch = str[i];
        int count = 0;
        while (ch == str[i] && i < n)
        {
            count++;
            i++;
        }
        str[idx++] = ch;
        if (count > 1)
        {
            string count = to_string(count);
            for (char c : count)
            {
                str[idx++] = c;
            }
        }
        i--;
    }
    str.resize(idx);

    cout << str << endl;
    cout << str.length() << endl;
    return 0;
}