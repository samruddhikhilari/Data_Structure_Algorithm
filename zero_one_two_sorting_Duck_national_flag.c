#include <stdio.h>
int main()
{
    int a[] = {0, 2, 2, 0, 0, 2, 2, 1};
    int n = sizeof(a) / sizeof(int);
    int low = 0, mid = 0, high = n - 1;
    while (mid <= high)
    {
        if (a[mid] == 0)
        {
            int temp = a[low];
            a[low] = a[mid];
            a[mid] = temp;

            low++;
            mid++;
        }
        else if (a[mid] == 1)
        {
            mid++;
        }
        else if (a[mid] == 2)
        {
            int temp = a[high];
            a[high] = a[mid];
            a[mid] = temp;
            high--;
        }
    }
    for (int i = 0; i < n; i++)
    {
        printf(" %d ", a[i]);
    }
    return 0;
}