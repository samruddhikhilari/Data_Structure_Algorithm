#include <stdio.h>
// below is an kadane's approch states that if sum comes as -ve value no need to considered it for further calculation
// O(n)
int main()
{
    int nums[] = {
        -1,
        -2,
        -3,
        -4,
    };
    int n = sizeof(nums) / sizeof(int);

    int cursum = 0, maxsum;
    for (int i = 0; i < n; i++)
    {
        // cursum += nums[i];
        printf("%d", cursum);
        if (cursum > maxsum)
            maxsum = cursum;
        // printf("%d", maxsum);

        if (cursum < 0)
            cursum = 0;
    }

    printf("maximum subarray sum : %d", maxsum);
    return 0;
}