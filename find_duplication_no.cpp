#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int n = 4;
    int arr[n + 1] = {1, 4, 4, 4, 3};
    int slow = arr[0];
    int fast = arr[0];
    do
    {
        slow = arr[slow];      //+1
        fast = arr[arr[fast]]; //+2
    } while (slow != fast); // stops i.e cycle present
    // how to find duplicate(cyclic point)
    slow = arr[0];
    while (slow != fast)
    {
        slow = arr[slow]; // conside nextnode(val)as an node(idx) ans find that node's nnode
        fast = arr[fast];
    }
    cout << fast;
    return 0;
}
// in-place array solution
/*
if array of n+1 size
and range always starts from 1 to n
what idexes we will have same values will be the i.e the idx always any idex's values
like 3 indx from 0 1 2 and 3 definately if val range starts from 1 to upto n then that's going to be presenes of idx=3 at idx-1 but this is sorted array case so no guarantee about pos of value
but guarantee about it present into the array.
i.e index always pointing to particular value right
i.e like LL structre having value with next pointer
so can we imagine our array in LL with the help of idx and value
we have to options arr idx & val
but for what which considered in between
idx == node val
val == pointer or vise versa
to descide this we can ellaborate arr's concept as to access it's val we always requires the idx
so val ==> idx as node==> next pointer not good option bcoz how to acces first node for that accessing the 0th index first as the node & it's val as next pointer is conclusion.
****steps
1. represent array in Linked List format.
2.idx==> node, arr val==> node pointer
3. after iteration the nextnode considered to a val asume as the node(idx)and access it's val
4.if any repetative val present it will definetly points two times.in cyclic forn
4.?how to track to cycle there is something slow & fast pointer concept to track cycle
5. find cyclic point bcoz that's going to be the duplicate point
*/