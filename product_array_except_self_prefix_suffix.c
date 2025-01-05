#include <stdio.h>
int main()
{
    int a[] = {1, 2, 3, 4};
    int n = sizeof(a) / sizeof(int);
    int ans[] = {1, 1, 1, 1};
    for (int i = 1; i < n; i++)
    {
        ans[i] = ans[i - 1] * a[i - 1];
    }
    int suffix = 1;
    for (int i = n - 2; i >= 0; i--)
    {
        suffix *= a[i + 1];
        ans[i] *= suffix;
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d ", ans[i]);
    }
    return 0;
}
// tc =>O(n+n+n)=>)O(3n)=>O(n) and sc => other tha a , ans only constants have been used
// actuall logic is except product i.e ith prefix and suffix multiplication