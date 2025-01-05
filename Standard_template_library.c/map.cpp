#include <iostream>
#include <map>

using namespace std;
int main()
{
    map<string, int> m;
    m["tv"] = 32;
    m["remote"] = 2;
    m["phone"] = 2;
    m["laptop"] = 12;

    cout << m.size();
    return 0;
}

/*
map     table format   =============
                       |key : value|
                       |key : value|
                       |key : value|
                       |key : value|
                       |key : value|
                       |key : value|
                       =============
key : value
1.unique  //multimap   //duplicates allow but sorted
2. sorted  //unordered_map //unique but unsorted saves sorting TC
*/

/*
insert,emplace
count
erase
find => if find it's iterator index else end() pointer
size , empty
 */