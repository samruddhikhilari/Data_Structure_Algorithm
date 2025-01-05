#include <iostream>
using namespace std;
int fibo(int pos)
{
    if (pos == 1 || pos == 0)
    {
        return pos;
    }
    return fibo(pos - 1) + fibo(pos - 2);
}
int main()
{
    int pos = 5;
    cout << " " << fibo(pos);
    return 0;
}