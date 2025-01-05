#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<int> arr = {5, 2, 11, 7, 15};
    pair<int, int> pair;
    int n = arr.size();
    int tar = 9;
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (arr[i] + arr[j] == tar)
            {
                pair.first = i;
                pair.second = j;
            }
        }
    }
    cout << pair.first << " " << pair.second;
    return 0;
}

/*
TC => O(n^2)
 */