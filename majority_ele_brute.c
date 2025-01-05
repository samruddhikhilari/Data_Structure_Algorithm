#include <stdio.h>
int main()
{
    int nums[] = {3, 4, 4, 1, 4, 3, 4, 2};
    int n = sizeof(nums) / sizeof(int);
    for (int i = 0; i < n; i++)
    {
        int freq = 0;
        for (int j = 0; j < n; j++)
        {
            if (nums[i] == nums[j])
            {
                freq++;
            }
        }
        if (freq > (n / 2))
        {
            printf("majority ele is : %d", nums[i]);
            break;
        }
    }
    return 0;
}