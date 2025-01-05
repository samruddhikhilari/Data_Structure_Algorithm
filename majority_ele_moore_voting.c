#include <stdio.h>
int main()
{
    int nums[] = {1, 2, 3, 4, 4, 4, 4};
    int n = sizeof(nums) / sizeof(int);
    int freq = 0, ans = 0;
    for (int i = 0; i < n; i++)
    {
        if (freq == 0)
        {
            ans = nums[i];
        }
        if (nums[i] == ans)
        {
            freq++;
        }
        else
        {
            freq--;
        }
    }
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        if (nums[i] == ans)
        {
            freq++;
        }
    }
    if (freq > (n / 2))
    {
        printf("majority ele is : %d", ans);
    }

    return 0;
}