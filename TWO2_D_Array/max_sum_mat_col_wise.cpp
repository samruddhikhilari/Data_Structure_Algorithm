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
    int maxsum = __WINT_MIN__;
    for (int j = 0; j < n; j++)
    {
        int sum = 0;
        for (int i = 0; i < m; i++)
        {
            sum += mat[i][j];
        }
        if (sum >= maxsum)
        {
            maxsum = sum;
        }
    }
    cout << "Maximum sum : " << maxsum;
    return 0;
}