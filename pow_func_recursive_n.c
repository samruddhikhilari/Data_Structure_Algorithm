#include <stdio.h>
// recursive function
int powrecur(int x, int n)
{
    if (x == 0)
        return 0;
    if (x == 1)
        return 1;
    if (n == 0)
        return 1;

    int res = powrecur(x, n / 2); // n=4 but finding or n/2(2) return for n/2 to make compatible to 4 from 2 multiply the result
    res = res * res;              //
                                  // if not 4->2 can 5->2 so what about remaining 1 multiply it once with x value ;
    return (n % 2 == 1) ? res * x : res;
}

int main()
{
    int x = -2, n = 3;
    float res = powrecur(x, n);
    res = (x < 0) ? 1 / res : res; // for -n case
    printf("%f", res);
    return 0;
}