#include <stdio.h>
int main()
{
    int a[] = {32, 5, 13, -43, 29}, target = -43;
    int size = sizeof(a) / sizeof(int);
    for (int i = 0; i < size; i++)
    {
        if (a[i] == target)
        {
            printf("%d found at %d index", a[i], i);
            return 0;
        }
    }
    printf("%d nodt found", target);

    return 0;
}