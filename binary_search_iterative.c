#include <stdio.h>

int main()
{
    int arr[] = {3, 4, 23, 63, 67, 213};
    int target = 6863;
    int n = sizeof(arr) / sizeof(int);
    int st = 0, end = n - 1;
    while (st <= end)
    {
        int mid = st + (end - st) / 2;
        if (arr[mid] == target)
        {
            printf("present at : %d index location", mid);
            return 0;
        }
        if (target > arr[mid])
            st = mid + 1;
        if (target < arr[mid])
            end = mid - 1;
    }
    printf("not present at any index location");

    return -1;
}