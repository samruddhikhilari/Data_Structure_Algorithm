#include <stdio.h>
int main()
{
    // O(n)
    int height[] = {3, 2, 5, 21, 2, 7, 4};
    int s = sizeof(height) / sizeof(height[0]);
    int lp = 0, rp = s - 1;
    int water = 0, max = 0;
    while (lp < rp)
    {
        int wt = rp - lp;
        int ht = (height[lp] < height[rp]) ? height[lp] : height[rp];
        water = wt * ht;
        max = (water > max) ? water : max;
        (height[lp] < height[rp]) ? lp++ : rp--;
    }
    printf("max contained water is :%d", max);

    return 0;
}
// time complexity travel by lp(d point)+travel by rp(n-d point) d&-d will be get cancelled