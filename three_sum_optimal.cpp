#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int main()
{
    vector<int> arr = {-1, 0, 1, 2, -1, -4};
    int n = arr.size();
    sort(arr.begin(), arr.end());
    vector<vector<int>> utrip;
    for (int i = 0; i < n; i++)
    {
        if (i > 0 && arr[i] == arr[i - 1])
            continue; // no duplicate triplet starting with i
        int j = i + 1, k = n - 1;
        while (j < k)
        {
            int sum = arr[i] + arr[j] + arr[k];
            if (sum < 0)
            {
                j++;
            }
            else if (sum > 0)
            {
                k--;
            }
            else
            {
                vector<int> v = {arr[i], arr[j], arr[k]};
                utrip.push_back(v);
                j++, k--;
                while (j < k && arr[j] == arr[j - 1]) // for no duplicate trip with j values
                    j++;
            }
        }
    }
    for (auto &a : utrip)
    {
        for (int val : a)
        {
            cout << " " << val;
        }
        cout << endl;
    }
    return 0;
}
