#include <stdio.h>
int main()
{
    int no, sum = 0;
    printf("enter integer number");
    scanf("%d", &no);
    if (no <= 0)
    {
        printf("plz enter valid numbers");
        return 0;
    }

    while (no > 0)
    {
        int rem = no % 10;
        sum = (rem * 10) + sum;
        no = no / 10;
    }
    printf("reverse : %d", sum);
    return 0;
}