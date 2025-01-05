#include <stdio.h>
int main()
{
    int a[] = {3, 2, 54, 32, 42, 43};
    int n = sizeof(a) / sizeof(int);
    for (int i = 0; i < n - 1; i++)
    {
        int smaller = i;
        for (int j = i + 1; j < n; j++)
        {
            if (a[j] < a[smaller])
            {
                smaller = j;
            }
        }

        if (a[i] != a[smaller])
        {
            int temp = a[i];
            a[i] = a[smaller];
            a[smaller] = temp;
        }
    }
    for (int i = 0; i < n; i++)
    {
        printf(" %d ", a[i]);
    }
    return 0;
}