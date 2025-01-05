#include <stdio.h>
int main()
{
    int nums[] = {2, 3, 3, 4, 6, 21, 36};
    int n = sizeof(nums) / sizeof(int);
    int sum = 0, target = 27;
    int i = 0, j = n - 1;
    while (i < j)
    {
        sum = (nums[i] + nums[j]);
        if (sum > target)
        {
            j--;
        }
        else if (sum < target)
        {
            i++;
        }
        else
        {
            printf("target %d found at %d  , %d position ", target, i, i + 1);
            break;
        }
    }
    return 0;
}