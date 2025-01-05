#include <stdio.h>
int main()
{
    int n = 4;
    // first pyramid
    for (int i = 0; i < n; i++)
    {
        // spaces
        for (int j = 0; j < (n - i); j++)
        {
            printf("%c", ' ');
        }
        // star
        printf("%c", '*');
        // spaces,
        if (i != 0)
        {
            for (int j = 0; j < 2 * i - 1; j++)
            {
                printf("%c", ' ');
            }
            // start
            printf("%c", '*');
        }
        printf("\n");
    }
    // second diamond
    for (int i = 0; i < n - 1; i++)
    {
        // spaces
        for (int j = 0; j < i + 1; j++)
        {
            printf("%c", ' ');
        }
        // star
        printf("%c", '*');
        if (i != n - 2)
        {
            // spaces
            for (int j = 0; j < 2 * (n - i) - 5; j++)
            {
                printf("%c", ' ');
            }
            // star
            printf("%c", '*');
        }
        printf("\n");
    }
    return 0;
}