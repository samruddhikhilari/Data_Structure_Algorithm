#include <iostream>
using namespace std;
int first = -1, last;
void findoccur(string str, char ch, int i)
{
    if (i == str.length())
    {
        cout << "first : " << first << endl;
        cout << "second: " << last << endl;
    }
    if (str[i] == ch)
    {
        if (first == -1)
            first = i;
        else
        {
            last = i;
        }
    }

    // f
    findoccur(str, ch, i + 1);
}
int main()
{
    string str = "bcdaakdhagdkca";
    findoccur(str, 'a', 0);
    return 0;
}
// find first & last occurence of the char in string
//  basically find char in string the 1st => first & end=> last occ.