#include <stdio.h>
#include <stdbool.h>
int a[] = {10, 10, 10, 10};
int n = sizeof(a) / sizeof(int);
int pcount = 4;
bool ispossible(int maxAllowedtime)
{
    int p = 1, time = 0;
    for (int i = 0; i < n; i++)
    {
        if (time + a[i] <= maxAllowedtime)
        {
            time += a[i];
        }
        else
        {
            p++;
            time = a[i];
        }
    }
    return p <= pcount;
}
int main()
{
    // st => max at atleast single board by single person
    int max = 0, sum = 0;
    for (int i = 0; i < n; i++)
    {
        if (a[i] > max)
        {
            max = a[i];
        }
        sum += a[i];
    }
    int st = max, end = sum, mid, ans = 0;
    while (st <= end)
    {
        mid = st + (end - st) / 2;
        if (ispossible(mid))
        {
            ans = mid;
            end = mid - 1;
        }
        else
        {
            st = mid + 1;
        }
    }
    if (ans != 0)
        printf(" %d ", ans);
    return 0;
}