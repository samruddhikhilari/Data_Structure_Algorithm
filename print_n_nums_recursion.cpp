#include <iostream>
using namespace std;
int nums(int n)
{
    if (n == 0)
    {
        return 0;
    }
    cout << n;
    nums(n - 1);
}
int main()
{
    int n = 6;
    cout << " " << nums(n);

    return 0;
}