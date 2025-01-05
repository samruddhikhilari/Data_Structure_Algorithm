#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<int> arr = {-1, 0, 1, 2, -1, -4};
    int n = arr.size();
    vector<vector<int>> ans;
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0)
                {
                    vector<int> v = {arr[i], arr[j], arr[k]};
                    // sort(v.begin(),v.end());
                    ans.push_back(v);
                }
            }
        }
    }
    for (auto a : ans)
    {
        for (auto val : a)
        {
            cout << " " << val;
        }
        cout << endl;
    }
    return 0;
}
