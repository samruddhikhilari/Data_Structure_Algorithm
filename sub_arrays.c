#include <stdio.h>
int main()
{
    int nums[] = {1, 2, 3, 4, 5, 6, 7};
    int n = sizeof(nums) / sizeof(int);
    // for starting positions
    for (int i = 0; i < n; i++)
    {
        // for ending elements
        for (int j = i; j < n; j++)
        {
            // for retriving array with i(start), j(end) indexed
            for (int k = i; k <= j; k++)
            {
                printf("%d", nums[k]);
            }
            printf(" ");
        }
        printf("\n");
    }

    return 0;
}