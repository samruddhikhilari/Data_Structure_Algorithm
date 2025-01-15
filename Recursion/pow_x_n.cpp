#include <iostream>
using namespace std;
int findpow(int no, int pow)
{
    // base cases
    if (pow == 0)
    {
        return 1;
    }
    if (no == 0)
    {
        return 0;
    }
    // x * x^n-1
    return no * findpow(no, pow - 1);
}
int main()
{
    int no = 2, pow = 3;
    cout << findpow(no, pow);
    return 0;
}