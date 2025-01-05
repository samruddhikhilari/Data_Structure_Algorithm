#include <stdio.h>
int main()
{
    int a[] = {5, 19, 710, 0, 0, 0};
    int b[] = {3, 10, 220};
    int m = 3, n = 3;
    int i = m - 1, j = n - 1;
    int indx = (m + n) - 1;
    while (i >= 0 && j >= 0)
    {
        if (a[i] > b[j])
        {
            a[indx--] = a[i--];
        }
        else
        {
            a[indx--] = b[j--];
        }
    }
    while (j >= 0)
    {
        a[indx--] = b[j--];
    }

    for (int i = 0; i < (m + n); i++)
    {
        printf(" %d ", a[i]);
    }
    return 0;
}