#include <stdio.h>
long int binary(int no)
{
    long int pow = 1, sum = 0, rem;
    while (no > 0)
    {
        rem = no % 2; // actual calculation
        sum = sum + (rem * pow);
        pow = pow * 10;
        no = no / 2;
    }
    return sum;
}

long int decimal(int bno)
{
    long int rem, sum = 0, pow = 1; // 2^1
    while (bno > 0)
    {
        rem = bno % 10;
        sum = sum + (rem * pow); // actual calculation
        pow = pow * 2;
        bno = bno / 10;
    }
    return sum;
}
int main()
{
    long int no, bno;
    printf("enter integer no :");
    scanf("%d", &no);
    bno = binary(no);
    printf("binary : %d", binary(no));
    printf("\ndecimal : %d", decimal(bno));

    return 0;
}