#include <stdio.h>
int main()
{
    int a[] = {1, 2, 3, 4};
    int n = sizeof(a) / sizeof(int);
    // by divisible operator
    int ans[n], pro = 1;
    for (int i = 0; i < n; i++)
    {
        pro *= a[i];
    }
    for (int i = 0; i < n; i++)
    {
        ans[i] = pro / a[i];
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d ", ans[i]);
    }
    return 0;
}