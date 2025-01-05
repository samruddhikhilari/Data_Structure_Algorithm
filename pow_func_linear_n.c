#include <stdio.h>
int main()
{
    int x = 2, n = 3;
    int pro = 1;
    for (int i = 0; i < n; i++)
    {
        pro = pro * x;
    }
    printf("%d", pro);
    return 0;
}