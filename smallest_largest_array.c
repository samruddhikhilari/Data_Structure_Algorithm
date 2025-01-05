#include <stdio.h>
int main()
{
    int a[] = {32, 5, 13, -43, 29};
    int smallest = __INT_MAX__, sindx;
    int largest = __WINT_MIN__, lindx;

    int size = sizeof(a) / sizeof(int);

    for (int i = 0; i < size; i++)
    {
        if (a[i] < smallest)
        {
            smallest = a[i];
            sindx = i;
        }
        if (a[i] > largest)
        {
            largest = a[i];
            lindx = i;
        }
    }
    printf("\n smallest :%d present at %d index", smallest, sindx);
    printf("\nlargest :%d present at %d index", largest, lindx);

    return 0;
}