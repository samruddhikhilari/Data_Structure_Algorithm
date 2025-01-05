#include <stdio.h>
int main()
{
    int a[] = {32, 5, 13, 43, 29};
    int size = sizeof(a) / sizeof(int);
    int sum = 0, pro = 1;
    for (int i = 0; i < size; i++)
    {
        sum += a[i];
        pro *= a[i];
    }

    printf("sum : %d ", sum);
    printf("product :%d ", pro);
    return 0;
}