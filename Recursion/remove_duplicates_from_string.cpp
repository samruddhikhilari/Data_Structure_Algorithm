#include <iostream>
#include <vector>
using namespace std;
void remove(string &str, int idx, vector<bool> &freq, string &newstr)
{
    if (idx == str.length())
    {
        cout << newstr;
        return;
    }
    if (!freq[str[idx] - 'a'])
    {
        newstr += str[idx];
        freq[str[idx] - 'a'] = true;
    }

    remove(str, idx + 1, freq, newstr);
}
int main()
{
    string str = "abbcasdbabd";
    vector<bool> freq(26, false);
    string newstr = "";
    int idx = 0;
    remove(str, idx, freq, newstr);
    return 0;
}