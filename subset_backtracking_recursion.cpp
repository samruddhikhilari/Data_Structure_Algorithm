#include <iostream>
#include <vector>
using namespace std;
void subset(vector<int> &arr, vector<int> &ans, int i) //[],[1],[1,2],[1,2,3]
{                                                      // 0,1,
    if (i == arr.size())                               // 0 ==3 NO , no,no,yes
    {
        for (int val : ans)
        {
            cout << " " << val;
        }
        cout << endl;
        return; //[1,2,3][1,2]
    }
    // include
    ans.push_back(arr[i]);   //[1],[1,2],[1,2,3]
    subset(arr, ans, i + 1); // 0,1 ,2
    // exclude
    ans.pop_back();          //[1,2]
    subset(arr, ans, i + 1); // 1
}
int main()
{
    vector<int> arr = {1, 2, 3};
    vector<int> ans;
    subset(arr, ans, 0); //[0],0
    return 0;
}
/*
1.working on ele include & exclude trick
2.include all element's one by one
3.do backtracking for each ele have been push
*/