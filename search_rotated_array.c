#include <stdio.h>
int main()
{
    int a[] = {5, 6, 7, 0, 1, 2};
    int target = 2, n = sizeof(a) / sizeof(int);

    int st = 0, end = n - 1, mid;
    while (st <= end)
    {
        mid = st + (end - st) / 2;
        if (a[mid] == target)
        {
            printf("\n %d", mid);
            return 0;
        }
        else if (a[st] <= a[mid]) // left sorted
        {
            if (a[st] <= target && target <= a[mid])
            {
                end = mid - 1;
            }
            else
            {
                st = mid + 1;
            }
        }
        else // right sorted
        {
            if (a[mid] <= target && target <= a[end])
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