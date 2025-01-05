#include <stdio.h>
int main()
{
    int p[] = {3, 2, 4, 1, 6, 3}; // 6-1
    int n = sizeof(p) / sizeof(int);
    int bestbuy = p[0], maxp = 0;
    for (int i = 1; i < n; i++)
    {
        if (p[i] > bestbuy)
        {
            maxp = ((p[i] - bestbuy) > maxp) ? (p[i] - bestbuy) : maxp;
        }
        bestbuy = (p[i] < bestbuy) ? p[i] : bestbuy;
    }
    printf("max profit : %d", maxp);
    return 0;
}