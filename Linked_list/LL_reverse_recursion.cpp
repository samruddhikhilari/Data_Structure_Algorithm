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

// reverse LL by recursion
Node *reverse_recursion(Node *head)
{

    if (head == NULL || head->next == NULL)
    {
        return head;
    }
    Node *newhead = reverse_recursion(head->next);
    head->next->next = head;
    head->next = NULL;
    return newhead;
}

class NodeList
{
    Node *head;
    Node *tail;

public:
    NodeList()
    {
        head = NULL;
        tail = NULL;
    }
    // push back
    void push_back(int data)
    {
        // create
        Node *node = new Node(data);
        if (head != NULL)
        {
            tail->next = node;
            tail = node;
        }
        else
        {
            head = tail = node;
        }
    }
    // print
    void print()
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

    void *reverse()
    {
        head = reverse_recursion(head);
    }
};
int main()
{
    NodeList *l1 = new NodeList();
    l1->push_back(1);
    l1->push_back(2);
    l1->push_back(3);
    l1->push_back(4);
    l1->push_back(5);
    l1->print();
    l1->reverse();
    l1->print();
}

/*
** REVERSE LL
if node stores add of next node change to store add of previous node
so track of prev & curr node is required but when curr points to the prev node right side ll can be lost so access it through out pointer as nex pointer
 */