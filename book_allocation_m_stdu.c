#include <stdio.h>
#include <stdbool.h>
bool isvalid(int *p, int n, int m, int maxAllowedpages)
{
    int stu = 1, pages = 0;
    for (int i = 0; i < n; i++)
    {
        if (p[i] > maxAllowedpages)
            return false;

        if (pages + p[i] <= maxAllowedpages)
        {
            pages += p[i];
        }
        else
        {
            stu++;
            pages = p[i];
        }
    }
    if (stu > m)
    {
        return false;
    }
    if (stu = m)
        return true;
}
int main()
{
    int p[] = {2, 5, 6, 8}, m = 2;
    int n = sizeof(p) / sizeof(int);
    int sum = 0, maxbook = 0;
    for (int i = 0; i < n; i++)
    {
        sum += p[i];
        if (p[i] > maxbook)
        {
            maxbook = p[i];
        }
    }
    int st = maxbook, end = sum, mid, ans = 0;
    while (st <= end)
    {
        mid = st + (end - st) / 2;
        if (isvalid(p, n, m, mid))
        {
            ans = mid;
            end = mid - 1;
        }
        else
        {
            st = mid + 1;
        }
    }
    printf(" %d", ans);
    return 0;
}