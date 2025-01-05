#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<vector<int>> mat = {
        {1, 4, 7, 11, 15},
        {2, 5, 8, 12, 19},
        {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
    int m = mat.size();
    int n = mat[0].size();
    int r = 0;
    int c = n - 1;
    int tar = 96;
    while (r <= m - 1 && c >= 0)
    {
        if (tar == mat[r][c])
        {
            cout << "target found at :" << r << c;
            return 0;
        }
        else if (tar > mat[r][c])
        {
            r++;
        }
        else
        {
            c--;
        }
    }
    cout << "target not found ";

    return 0;
}