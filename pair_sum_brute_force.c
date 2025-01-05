#include <stdio.h>
int main()
{
    int nums[] = {2, 3, 3, 4, 6, 21, 36};
    int n = sizeof(nums) / sizeof(int);
    int target = 24;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n - 1; j++)
        {
            if ((nums[i] + nums[j]) == target)
            {
                printf("target %d found at %d  , %d position ", target, i, i + 1);

                break;
            }
        }
    }
    return 0;
}