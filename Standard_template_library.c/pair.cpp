#include <iostream>
#include <vector>
using namespace std;
int main()
{
    /*
    // 1
    pair<int, int> p = {32, 12}; // when need to access two ele's always with pair
    cout << "first:" << p.first << endl;
    cout << "second:" << p.second << endl;

    // 2
    pair<int, pair<int, int>> p2 = {48, {2, 1}}; // when need to access two ele's always with pair
    cout << "first:" << p2.second.first << endl;
    cout << "second:" << p2.second.second << endl;
    */
    // 3
    vector<pair<int, int>> v = {{32, 31}, {83, 21}, {29, 45}, {9, 10}};
    v.push_back({46, 35});  // with
    v.emplace_back(11, 22); // without format it cares woformat =>>withformat
    for (auto p : v)
    {
        cout << "first :" << p.first << " second" << p.second << endl;
    }
    return 0;
}