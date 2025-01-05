#include <iostream>
#include <vector>
#include <set>

using namespace std;
int main()
{
    vector<int> arr = {-1, 0, 1, 2, -1, -4};
    int n = arr.size();
    vector<vector<int>> utrip;
    for (int i = 0; i < n; i++)
    {
        int tar = -arr[i];
        set<int> s; // finding third
        for (int j = i + 1; j < n; j++)
        {
            int third = tar - arr[j];
            if (s.find(third) != s.end())
            {
                vector<int> trip = {tar, arr[j], third};
                sort(trip.begin(), trip.end());

                utrip.insert(trip);
            }
            s.insert(arr[j]);
        }
    }
    return 0;
}
