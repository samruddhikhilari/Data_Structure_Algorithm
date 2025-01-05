#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<vector<int>> mat = {{1, 2, 3, 4},
                               {5, 6, 7, 8},
                               {9, 10, 11, 12},
                               {13, 14, 15, 16}};

    vector<int> v;
    int m = mat.size();
    int n = mat[0].size();
    printf("\n ");

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            printf("%d ", mat[i][j]);
        }
        printf("\n ");
    }

    int srow = 0, erow = m - 1, scol = 0, ecol = n - 1;

    while (srow <= erow && scol <= ecol)
    {
        // top
        for (int j = scol; j <= ecol; j++)
        {
            v.push_back(mat[srow][j]);
        }

        // right
        for (int j = srow + 1; j <= erow; j++)
        {
            v.push_back(mat[j][ecol]);
        }
        // bottom
        for (int j = ecol - 1; j >= scol; j--)
        {
            if (srow == erow)
                break;
            v.push_back(mat[erow][j]);
        }
        // left
        for (int j = erow - 1; j >= srow + 1; j--)
        {
            if (scol == ecol)
                break;
            ;
            v.push_back(mat[j][scol]);
        }
        srow++;
        scol++;
        erow--;
        ecol--;
    }
    for (int val : v)
    {
        cout << " " << val;
    }
    cout << endl;
    return 0;
}
