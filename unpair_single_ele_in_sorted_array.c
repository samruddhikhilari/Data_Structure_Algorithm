#include <stdio.h>
int main()
{
    int a[] = {1, 1, 2, 3, 3, 4, 4};
    int n = sizeof(a) / sizeof(int);
    int st = 0, end = n - 1, mid;
    while (st <= end)
    {
        mid = st + (end - st) / 2;
        if (a[mid - 1] != a[mid] && a[mid] != a[mid + 1])
        {
            printf("index %d", mid);
            return 0;
        }
        else if (mid % 2 == 0) // for even case
        {
            if (a[mid - 1] == a[mid])
            {
                end = mid - 1;
            }
            else
            {
                st = mid + 1;
            }
        }
        else // for odd case
        {
            if (a[mid - 1] == a[mid])
            {
                st = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
    }

    return -1;
}