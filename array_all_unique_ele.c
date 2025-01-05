#include <stdio.h>
int main()
{
    int a1[] = {11, 12, 13, 13};
    int a2[] = {1, 47, 323, 3};

    int flag = 0;
    int size1 = sizeof(a1) / sizeof(int);
    int size2 = sizeof(a2) / sizeof(int);

    for (int i = 0; i < size1; i++)
    {
        for (int j = 0; j < size2; j++)
        {
            if (a1[i] == a2[j])
            {
                flag = 1;
            }
        }
        if (flag == 1)
        {
            printf("%d ", a1[i]);
        }
    }
    return 0;
}