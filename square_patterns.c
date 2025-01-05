#include <stdio.h>
int main()
{
    printf("\n Square patterns : \n");
    int n = 4;
    /*
        for (int i = 0; i < n; i++)
        {
            // spaces
            for (int j = 0; j < i; j++)
            {
                printf("%c", ' ');
            }
            // nums
            for (int j = n; j > i; j--)
            {
                printf("%d", i + 1);
            }
            printf("\n");
        }
        */

    for (int i = 0; i < n; i++)
    {
        // first pyramid
        // spaces
        for (int j = 0; j < (n - i); j++)
        {
            printf("%c", ' ');
        }
        // nums
        for (int j = 0; j < (i + 1); j++)
        {
            printf("%d", j + 1);
        }
        // seond pyramid
        for (int j = i; j > 0; j--)
        {
            printf("%d", j);
        }
        printf("\n");
    }
    return 0;
}