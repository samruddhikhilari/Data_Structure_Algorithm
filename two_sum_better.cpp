#include <iostream>
#include <vector>
#include <set>

using namespace std;
int main()
{
    vector<int> arr = {5, 2, 11, 7, 15};
    pair<int, int> pair;
    int n = arr.size();
    int tar = 9;
    int b;
    set<int> s;
    for (int i = 0; i < n; i++)
    {
        int a = arr[i];
        b = tar - a;
        if (s.find(b) != s.end())
        {
            pair.first = a;
            pair.second = b;
            break;
        }
        else
        {
            s.insert(b);
        }
    }
    cout << pair.first << " " << pair.second;
    return 0;
}

/*
TC => O(n)
SC=>O(log)
 */