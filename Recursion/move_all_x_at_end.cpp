#include <iostream>
using namespace std;
void find(string &str, int idx, int count, string &newstr)
{
    if (idx == str.length())
    {
        while (count != 0)
        {
            newstr += 'x';
            count--;
        }
        cout << newstr;
        return;
    }
    if (str[idx] == 'x')
    {
        count++;
    }
    else
    {
        newstr += str[idx];
    }
    find(str, idx + 1, count, newstr);
}
int main()
{
    string str = "abcxkdhsxkdhexksxxkshd";
    string newstr = "";
    find(str, 0, 0, newstr);
    return 0;
}