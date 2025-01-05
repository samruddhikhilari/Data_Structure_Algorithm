#include <stdio.h>
#include <stdbool.h>
int a[] = {1, 2, 8, 4, 9}, cows = 2;
int n = sizeof(a) / sizeof(int);
bool ispossible(int maxdistance)
{
    // sorting of positions
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (a[j] > a[j + 1])
            {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
    int c = 1, lpos = a[0];
    for (int i = 1; i < n; i++)
    {
        if ((a[i] - lpos) >= maxdistance)
        {
            c++;
            lpos = a[i];
        }
        if (c == cows)
        {
            return true;
        }
    }
    return false;
}
int main()
{
    int st = 1, end, mid, ans = 0, max = 0, min = 0;
    for (int i = 0; i < n; i++)
    {
        if (a[i] > max)
        {
            max = a[i];
        }
        if (a[i] < min)
        {
            min = a[i];
        }
    }
    end = max - min;
    while (st <= end)
    {
        mid = st + (end - st) / 2;
        if (ispossible(mid))
        {
            ans = mid;
            st = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    printf(" %d ", ans);
    return 0;
}