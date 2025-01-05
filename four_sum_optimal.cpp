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
            continue;
        for (int j = i + 1; j < n; j++)
        {
            if (j > i + 1 && arr[j] == arr[j - 1])
                continue;
            int p = j + 1, q = n - 1;
            while (p < q)
            {
                int sum = arr[i] + arr[j] + arr[p] + arr[q];
                if (sum < 0)
                {
                    p++;
                }
                else if (sum > 0)
                {
                    q--;
                }
                else
                {
                    vector<int> v = {arr[i], arr[j], arr[p], arr[q]};
                    utrip.push_back(v);
                    p++, q--;
                    while (p < q && arr[p] == arr[p - 1])
                        p++;
                }
            }
        }
    }

    for (auto &trip : utrip)
    {
        for (int val : trip)
        {
            cout << " " << val;
        }
        cout << endl;
    }
    return 0;
}
