#include <stdio.h>
int main()
{
    int a[] = {1, 8, 5}; // first permutation array in ascending
    int p = -1;
    int n = sizeof(a) / sizeof(int);
    // pivot the point from which descresing start from end to start direction
    // find pivot
    for (int i = n - 2; i >= 0; i--)
    {
        if (a[i] < a[i + 1])
        {
            p = i;
            break;
        }
    }
    if (p == -1)
    {
        int i = 0, j = n - 1;
        while (i <= j)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        for (int i = 0; i < n; i++)
        {
            printf("%d ", a[i]);
        }

        return 1;
    }
    // find right most greater than pivot and swap
    int g = 0;
    for (int i = n - 1; i > p; i--)
    {
        if (a[i] > a[p])
        {
            g = i;
            break;
        }
    }
    int temp = a[p];
    a[p] = a[g];
    a[g] = temp;
    // reverse from pivot +1 position
    int i = p + 1, j = n - 1;
    while (i <= j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        i++;
        j--;
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }
    return 0;
}