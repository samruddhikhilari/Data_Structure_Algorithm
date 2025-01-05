#include <stdio.h>
int main()
{
    int a[] = {2, 4, 32, 64, 23, 43};
    int n = sizeof(a) / sizeof(int);
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++) // ascen
        {
            if (a[j] > a[j + 1])
            {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        printf(" %d ", a[i]);
    }
    return 0;
}