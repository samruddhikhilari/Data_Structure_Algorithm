#include <iostream>
#include <vector>
using namespace std;
int main()
{
    // creation
    // vector<int> v = {1, 2, 3};
    // vector<int> v(2, 0); // size,default values
    vector<int> v(0);
    vector<int> v2(v);
    // functions
    v.push_back(23);    // without formating adds
    v.emplace_back(53); // format's as per vector in which we are adding
    v.push_back(48);
    v.push_back(10);
    v.push_back(0);                               // adds at last
    v.pop_back();                                 // removes last
    cout << "size :" << v.size() << endl;         // length of elements
    cout << "capacity: " << v.capacity() << endl; // storing capacity
    // access
    for (int val : v)
    {
        cout << " " << val;
    }
    cout << endl;
    cout << "at 2 ind :" << v.at(2) << endl;
    cout << "at 0 indx:" << v[0] << endl;
    cout << "at front indx:" << v.front() << endl;
    cout << "at back indx:" << v.back() << endl;
    // cout << "hello samu";
}
// insert = insert ele,