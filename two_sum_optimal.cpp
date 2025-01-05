#include <iostream>
#include <vector>
#include <set>

using namespace std;
int main()
{
    vector<int> arr = {5, 2, 11, 7, 15};
    pair<int, int> pair;
    sort(arr.begin(), arr.end());
    int n = arr.size();
    int tar = 9;
    int i = 0, j = n - 1;
    while (i < j)
    {
        int sum = arr[i] + arr[j];
        if (sum == tar)
        {
            pair.first = i;
            pair.second = j;
            break;
        }
        else if (sum < tar)
        {
            i++;
        }
        else
        {
            j--;
        }
    }

    cout << pair.first << " " << pair.second;
    return 0;
}

/*
TC => O(n)
SC=>O(1)
 */