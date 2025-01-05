#include <stdio.h>
int main()
{
    int a[] = {32, 5, 13, -43, 29};
    int size = sizeof(a) / sizeof(int);
    int start = 0, end = size - 1;
    int temp;
    for (int i = 0; i < size; i++)
    {
        while (start < end)
        {
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }

    for (int i = 0; i < size; i++)
    {
        printf("%d ", a[i]);
    }

    return 0;
}