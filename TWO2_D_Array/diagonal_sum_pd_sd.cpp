#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<vector<int>> mat = {
        {1, 2, 3},
        {1, 2, 3},
        {1, 2, 3},
    };
    int m = mat.size();
    int n = mat[0].size();
    int sum = 0;
    for (int i = 0; i < m; i++)
    {
        cout << sum << " ";
        sum += mat[i][i];
        cout << sum << " ";
        sum += mat[0][n - i - 1];
    }
    if (m % 2 == 1)
    { // odd length matrix avoid center diagonal two times
        sum = sum - mat[m / 2][m / 2];
    }
    cout << "sum of diagonal :" << sum;

    return 0;
}