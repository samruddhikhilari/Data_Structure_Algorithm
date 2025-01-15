#include <iostream>
#include <string>
using namespace std;

class Node
{
public:
    int val;
    Node *next;
    Node(int i)
    {
        val = i;
        next = NULL;
    }
};
class NodeList
{
    Node *head1 = NULL;
    Node *head2 = NULL;

public:
    NodeList()
    {
        head1 = new Node(1);
        head2 = new Node(2);
    }

    // create 2 list's
    void create()
    {
        Node *temp1 = head1;
        Node *temp2 = head2;
        // first ll 2,3,15,60
        int count = 1;
        for (int i = 0; i < 4; i++)
        {
            Node *currnode = new Node(count * 2);
            temp1->next = currnode;
            temp1 = currnode;
            count++;
        }
        // second ll
        count = 2;
        for (int i = 0; i < 4; i++)
        {
            Node *currnode = new Node(count * 3);
            temp2->next = currnode;
            temp2 = currnode;
            count++;
        }
        print(head1);
        print(head2);
        print(merged(head1, head2));
    }

    // merged
    Node *merged(Node *h1, Node *h2)
    {
        // base start or stop case
        if (h1 == NULL || h2 == NULL)
        {
            return (h1 == NULL) ? h2 : h1;
        }
        if (h1->val <= h2->val)
        {
            h1->next = merged(h1->next, h2);
            return h1;
        }
        else
        {
            h2->next = merged(h1, h2->next);
            return h2;
        }
    }
    // print
    void print(Node *head)
    {
        if (head == NULL)
        {
            cout << "LL is NULL";
        }
        else
        {
            Node *temp = head;
            while (temp != NULL)
            {
                cout << temp->val << "-> ";
                temp = temp->next;
            }
            cout << endl;
        }
    }
};
int main()
{
    NodeList *l1 = new NodeList();
    l1->create();
}

/*
** mergest two sorted LL
1. two LL
2.merged using recursion
 */