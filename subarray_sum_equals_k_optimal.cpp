#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;
int main()
{
    vector<int> arr = {0, 1, -1, 2, -1};
    int n = arr.size();
    int tar = 0;
    // prefix sum
    vector<int> ps(n, 0);
    ps[0] = arr[0];
    for (int i = 1; i < n; i++)
    {
        ps[i] = ps[i - 1] + arr[i];
    }
    // compare tar with ps
    int count = 0;
    unordered_map<int, int> m;
    for (int i = 0; i < n; i++)
    {
        if (ps[i] == tar)
        {
            count++;
        }
        int remain = ps[i] - tar;
        if (m.find(remain) != m.end())
        {
            count += m[remain];
        }
        if (m.find(ps[i]) == m.end())
        {
            m[ps[i]] = 0;
        }
        m[ps[i]]++;
    }
    cout << " " << count;
    return 0;
}
/*
1.instead of finding subarrays & the cal their sum & then compare
2.directly get sum check with target */