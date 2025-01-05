#include <iostream>
#include <string>
using namespace std;
int main()
{
    string a = "racecar";
    int i = 0, j = (sizeof(a) / sizeof(char)) - 1;
    int flag = 1;
    while (i < j)
    {
        printf("\n %d %d ", a[i], a[j]);
        if (!(a[i] == a[j]))
            flag = 0;
        i++;
        j--;
    }

    if (flag)
        printf("string is pallindrome");
    else
        printf("string is not pallindrome");
    return 0;
}
