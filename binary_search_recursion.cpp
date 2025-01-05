#include <iostream>
#include <vector>
using namespace std;
int asearch(vector<int> arr, int tar, int st, int end)
{
    if (st <= end)
    {
        int mid = st + (end - st) / 2;
        if (arr[mid] == tar)
        {
            return mid;
        }
        else if (tar < arr[mid])
        {
            return asearch(arr, tar, st, mid - 1);
        }
        else
        {
            return asearch(arr, tar, mid + 1, end);
        }
    }
    return -1;
}
int main()
{
    vector<int> arr = {1, 2, 4, 5, 8};
    int n = arr.size();
    int tar = 8;
    int st = 0, end = n - 1;
    cout << asearch(arr, tar, st, end);
    return 0;
}

/*
1.mid,st,end
2.left p , right p
*/