#include <iostream>
#include <string>
using namespace std;
int main()
{
    // string
    // words
    string str = "a bat is green";
    string rev = "";
    for (int i = str.length() - 1; i >= 0; i--)
    {
        rev += str[i];
    }
    string ans = "";
    for (int i = 0; i < rev.length(); i++)
    {

        string word = "";
        while (i < rev.length() && rev[i] != ' ')
        {
            word += rev[i];
            i++;
        }
        if (!word.empty())
        {
            // word reverse
            string temp = word;
            word = "";
            for (int i = temp.length(); i >= 0; i--)
            {
                word += temp[i];
            }

            if (ans.empty())
                ans = word;
            else
                ans += " " + word;
        }
    }
    cout << ans;
    return 0;
}