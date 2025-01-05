#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<int> arr = {1, 0, -1, 2, 4};
    int tar = 0;
    int n = arr.size();
    cout << endl;
    // find subarrays
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        int sum = 0;
        // start point
        for (int j = i; j < n; j++) // end point
        {
            for (int k = i; k <= j; k++) // retrive subarrys
            {
                sum += arr[k];
                if (sum == tar)
                {
                    count++; // 2
                }
            }
        }
    }
    cout << "count :" << count;
    return 0;
}
/*
1.find subarrays
2.cal sum
3.compare count++
 */