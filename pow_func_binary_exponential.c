#include <stdio.h>
int main()
{
    int n = -2;
    // decimal to binary
    int rem, pow = 1, binary = 0;
    printf("n : %d", n);
    while (n > 0)
    {
        rem = n % 2;
        binary += (rem * pow);
        pow *= 10;
        n = n / 2;
    }
    // looping through binary n to O(log n)transcations
    int ans = 1, x = 2.00000;
    printf("\nx : %d", x);
    while (binary > 0)
    {
        rem = binary % 10;
        if (rem)
            ans *= x;
        x = x * x;
        binary = binary / 10;
    }

    printf("\nans : %d ", ans);
    return 0;
}