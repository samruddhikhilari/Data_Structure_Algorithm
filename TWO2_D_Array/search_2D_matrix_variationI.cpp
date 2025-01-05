#include <iostream>
#include <vector>
using namespace std;
int tar = 18;
bool searchInRow(vector<vector<int>> mat, int midrow)
{
    int n = mat[0].size();
    int s = 0, end = n - 1, mid;

    while (s <= end)
    {
        mid = s + (end - s) / 2;
        if (tar == mat[midrow][mid])
        {
            cout << "target found " << midrow << " " << mid;
            return true;
        }
        else if (tar > mat[midrow][mid])
        {
            s = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return false;
}
int main()
{
    vector<vector<int>> mat = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};

    int m = mat.size();
    int n = mat[0].size();
    // solution 1 O(log m*n)
    // 1.binary seach on rows
    int srow = 0, erow = m - 1, mid;
    bool found = false;
    while ((srow <= erow))
    {
        mid = srow + (erow - srow) / 2;
        if (mat[mid][0] <= tar && tar <= mat[mid][n - 1])
        {
            // 2.binary seach on rows col elements
            found = searchInRow(mat, mid);
            break;
        }
        else if (tar > mat[mid][n - 1])
        {
            srow = mid + 1;
        }
        else
        {
            erow = mid - 1;
        }
    }
    if (!found)
    {
        cout << "not found";
    }
    return 0;
}

/*
1.row's asecding left -> right
2.each row's first ele is always greater than previous row's last element.
 */