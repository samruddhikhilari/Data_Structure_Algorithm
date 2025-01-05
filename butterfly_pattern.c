#include <stdio.h>
int main()
{
    int n = 4;

    // top
    for (int i = 0; i < n; i++)
    {
        // star
        for (int j = 0; j < (i + 1); j++)
        {
            printf("%c", '*');
        }
        // space
        if (i != n - 1)
        {
            for (int j = 0; j < 2 * (n - i - 1); j++)
            {
                printf("%c", ' ');
            }
        }
        // star
        for (int j = 0; j < (i + 1); j++)
        {
            printf("%c", '*');
        }
        printf("\n");
    }

    // bottom
    for (int i = 0; i < n; i++)
    {
        // star
        for (int j = n; j > i; j--)
        {
            printf("%c", '*');
        }
        // space
        if (i != 0)
        {
            for (int j = 0; j < (2 * (i - 1)) + 2; j++)
            {
                printf("%c", ' ');
            }
        }
        // star
        for (int j = n; j > i; j--)
        {
            printf("%c", '*');
        }
        printf("\n");
    }
    return 0;
}