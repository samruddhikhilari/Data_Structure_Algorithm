#include <stdio.h>
int main()
{
    int a[] = {1, 2, 3, 4};
    int n = sizeof(a) / sizeof(int), ans[] = {1, 1, 1, 1};
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (i != j)
            {
                ans[i] *= a[j];
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d ", ans[i]);
    }
    return 0;
}