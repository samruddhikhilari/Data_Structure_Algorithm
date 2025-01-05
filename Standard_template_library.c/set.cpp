#include <iostream>
#include <set>
using namespace std;
int main()
{
    set<int> s;
    s.insert(12);
    s.insert(2);
    s.insert(33);
    s.insert(446);
    s.insert(5);

    for (auto v : s)
    {
        cout << " " << v << endl;
    }
    return 0;
}
// sorted data
/*
s.lower_bound(val) // less than val not allow as that val or if not present it's greater val
s.upper_bound(val) // allow only greater value than val;

 */
