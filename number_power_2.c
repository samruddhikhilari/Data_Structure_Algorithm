// approach 1 by only bitwise &
//-/- 2 by >> operator

#include <stdio.h>
#include <stdbool.h>

bool poweroftwo(int no)
{
    if (no <= 0)
    {
        return false;
    }

    if ((no & (no - 1)) == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

bool poweroftwo2(int no)
{
    if (no <= 0)
    {
        return false;
    }

    while (no > 1)
    {
        if (no & 1)
        {
            return false;
        }
        no = no >> 1;
    }
    return true;
}
int main()
{
    int no, ch;
    printf("enter integer number");
    scanf("%d", &no);

    printf("\nchoice approach");
    printf("\n1.by only &");
    printf("\n2.by >>, &");
    scanf("%d", &ch);

    switch (ch)
    {
    case 1:
        if (poweroftwo(no))
        {
            printf("%d is power of 2", no);
        }
        else
        {
            printf("%d is not power of 2", no);
        }
        break;
    case 2:
        if (poweroftwo2(no))
        {
            printf("%d is power of 2", no);
        }
        else
        {
            printf("%d is not power of 2", no);
        }
        break;
        return 0;
    }
}