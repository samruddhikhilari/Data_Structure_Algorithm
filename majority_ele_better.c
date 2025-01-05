#include <stdio.h>
int main()
{
    int nums[] = {4, 4, 4, 4, 1, 2, 3}; // with sorted array
    int n = sizeof(nums) / sizeof(int);
    int freq = 1, ans = nums[0];
    for (int i = 0; i < n; i++)
    {
        if (nums[i] == ans)
        {
            freq++;
        }
        else
        {
            ans = nums[i];
            freq = 1;
        }
        if (freq > (n / 2))
        {
            printf("majority ele is : %d", ans);

            break;
        }
    }

    return 0;
}