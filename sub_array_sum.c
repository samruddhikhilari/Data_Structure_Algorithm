#include <stdio.h>
int main()
{
    int nums[] = {1, -2, 3, -4, 5, 6, 7};
    int n = sizeof(nums) / sizeof(int);

    int maxsum = __WINT_MIN__;
    // O(n^2)
    for (int i = 0; i < n; i++)
    {
        int cursum = 0;
        for (int j = i; j < n; j++)
        {
            cursum += nums[j];
            if (cursum > maxsum)
            {
                maxsum = cursum;
            }
        }
    }
    printf("maximum subarray sum :%d", maxsum);

    return 0;
}