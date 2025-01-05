#include <stdio.h>
int main()
{
    int a[] = {0, 1, 6, 1, 0};
    int st = 1, n = sizeof(a) / sizeof(int), end = n - 2, mid;
    while (st <= end)
    {
        mid = st + (end - st) / 2;
        if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) // ind which is end point for left ascending and start for right descending order elements
        {
            printf("%d", mid);
            return 0;
        }
        else if (a[mid] - 1 < a[mid]) // i.e it's on incresing means on left side no need to travel left as it will give more ascending ordered values only.
        {
            st = mid + 1;
        }
        else // i.e it's on decresing means on right side
        {
            end = mid - 1;
        }
    }

    return -1;
}
// it's always a mountain array mean always it have a peak index into the array
