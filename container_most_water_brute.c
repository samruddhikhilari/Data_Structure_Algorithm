#include <stdio.h>
int main()
{
    int height[] = {1, 2, 5, 6, 7, 3, 8};
    int s = sizeof(height) / sizeof(int);
    int water = 0, max = 0;
    for (int i = 0; i < s; i++) // left pointer
    {
        for (int j = i + 1; j < s; j++)
        {
            int wt = j - i;
            int ht = (height[i] < height[j]) ? height[i] : height[j];
            water = wt * ht;
            max = (water > max) ? water : max;
        } // right point
    }

    printf("max containg water :%d", max);
    return 0;
}
// O(n^2)
//  just sem works as subarray like start(left pointer)and end(right pointer)
