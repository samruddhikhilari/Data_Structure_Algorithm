#include <iostream>
#include <string>
using namespace std;
bool ismatch(int f1[], int f2[])
{
    bool flag = true;
    for (int i = 0; i < 26; i++)
    {
        if (f1[i] != f2[i])
        {
            flag = false;
        }
    }
    if (flag)
        return true;
    return false;
}
int main()
{
    string str1 = "xyz";
    string str2 = "abcdexydzfg";
    int freq[26] = {0};
    int n = str2.length();
    int wlength = str1.length();
    // cal str1 frequ
    for (int i = 0; i < str1.length(); i++)
    {
        freq[str1[i] - 'a']++;
    }

    for (int i = 0; i < n; i++)
    {
        int idx = i, widx = 0;
        int wfreq[26] = {0};
        while (idx < n && widx != wlength)
        {
            wfreq[str2[idx] - 'a']++;
            idx++;
            widx++;
        }
        if (ismatch(freq, wfreq))
        {
            cout << "given string permutation found";
            return 1;
        }
    }
    cout << "permutation not found";

    return 0;
}