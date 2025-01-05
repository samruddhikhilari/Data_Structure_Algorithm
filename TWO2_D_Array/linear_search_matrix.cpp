#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<vector<int>> mat = {
        {41, 2, 23},
        {1, 0, 3},
        {71, 27, 3},
    };
    int m = mat.size();
    int n = mat[0].size();
    int tar = 10;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (tar == mat[i][j])
            {
                cout << "target found at :" << i << j;
                return 0;
            }
        }
    }
    cout << "target not found ";
    return 0;
}