#include <iostream>
#include <vector>
#include <set>
using namespace std;
int main()
{
    vector<int> v = {1, 2, 3, 5, 4, 1};
    int n = 6, a, b;
    set<int> s;
    for (int i = 0; i < v.size(); i++)
    {
        if (s.find(v[i]) != s.end())
        {
            a = v[i];
            cout << "repeted val :" << v[i] << endl;
            break;
        }
        s.insert(v[i]);
    }
    int asum = 0, psum = n * (n + 1) / 2;
    for (int i = 0; i < v.size(); i++)
    {
        asum += v[i];
    }
    // cal missing val
    b = psum + a - asum;
    cout << "present sum :" << asum << endl;
    cout << psum << endl;
    cout << "missing val :" << b;
    return 0;
}
/*
**note
a. arr size is n
b. arr must have 1 to n range values
c. but in 1 to n range arr miss one val and replace with any repeating val.

**find repeative values
1. take all vals one by one & then insert each ele in set if while adding any element it already present into the set means it's the repeated val
 */
