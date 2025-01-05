#include <stdio.h>
int main()
{
    int a[] = {2, 32, 12, 64, 73, 42};
    int n = sizeof(a) / sizeof(a[0]);

    for (int i = 1; i < n; i++)
    {
        int temp = a[i];
        int j = i - 1;
        while (a[j] > temp && j >= 0)
        {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = temp;
    }
    for (int i = 0; i < n; i++)
    {
        printf(" %d ", a[i]);
    }
    return 0;
}