// an int nums array having twice all elements except 1 find that one
#include <stdio.h>
int main()
{
    int nums[] = {2, 1, 2, 3, 1};
    int n = sizeof(nums) / sizeof(int), sum = 0;
    for (int i = 0; i < n; i++)
    {
        sum = sum ^ nums[i];
    }
    printf("%d", sum);
    return 0;
}

// n ^n => 0 like in math -1 and +1 canceled in bits 1 ^ 1 canceles.
// n^ 0 =>n