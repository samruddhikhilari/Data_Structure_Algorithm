#include <iostream>
#include <list>
using namespace std;
int main()
{
    list<int> l = {32, 3, 5, 2, 1}; // doubly linked list implementation
    // before op's
    for (auto val : l)
    {
        cout << " " << val;
    }
    cout << endl;
    cout << "list front push" << endl;
    l.push_front(10);
    l.push_back(11);
    l.emplace_front(20);
    l.emplace_back(21);
    // cout<<l[0] //can't access as it's linked list
    //  after op's
    for (auto val : l)
    {
        cout << " " << val;
    }
    cout << endl;
    l.pop_front();
    l.pop_back();
    cout << "size :" << l.size() << endl;
    return 0;
}

/*
other fun's
size =count of ele's
erase=pop ele,
clear=remove all ele;size=0 but capacity=(as it is)
empty=(1|0) list empty or not
*/