#include <stdio.h>
int main()
{
    int a[] = {0, 2, 2, 0, 0, 2, 2, 1};
    int n = sizeof(a) / sizeof(int);
    printf("%d", n);
    int count0 = 0, count1 = 0, count2 = 0;
    for (int i = 0; i < n; i++)
    {
        if (a[i] == 0)
            count0++;
        else if (a[i] == 1)
            count1++;
        else if (a[i] == 2)
            count2;
    }

    int indx = -1;
    for (int i = 0; i < count0; i++)
    {
        a[++indx] = 0;
    }
    for (int i = 0; i < count1; i++)
    {
        a[++indx] = 1;
    }
    for (int i = 0; i < count2; i++)
    {
        a[++indx] = 2;
    }
    for (int i = 0; i < n; i++)
    {
        printf(" %d ", a[i]);
    }
    printf("%d", n);
    return 0;
}