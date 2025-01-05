#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<int> vec = {3, 26, 421, 37, 42};
    cout << vec.size() << endl;

    cout << "forward traversing" << endl;
    for (auto it = vec.begin(); it != vec.end(); it++)
    {
        cout << " " << *it;
    }
    cout << endl;
    cout << "reverse traversing" << endl;
    for (auto it = vec.rbegin(); it != vec.rend(); it++)
    {
        cout << " " << *it;
    }
    return 0;
}

// begin points to start 0 indx
// end points to (end+1) indx to cover entire array and 1 extra block