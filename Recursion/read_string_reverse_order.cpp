#include <iostream>
using namespace std;
void read(string str, int n)
{
    if (n == 1)
    {
        cout << str[n - 1];
        return;
    }
    // base case
    cout << str[n - 1];
    read(str, n - 1);
}
int main()
{
    string str = "abcd";
    read(str, str.length());
    return 0;
}