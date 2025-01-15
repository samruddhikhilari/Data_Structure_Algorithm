#include <iostream>
#include <string>
using namespace std;

class Node
{
public:
    string val;
    Node *next;
    Node(string i)
    {
        val = i;
        next = NULL;
    }
};
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
    void push_back(string data)
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

    // reverse LL
    void *reverse()
    {
        if (head == NULL)
        {
            cout << "sorry ll is null";
            return 0;
        }
        else
        {
            Node *curr = head;
            Node *prev = NULL;
            Node *next = NULL;
            while (curr != NULL)
            {
                next = curr->next;
                curr->next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
            print();
        }
    }
};
int main()
{
    NodeList *l1 = new NodeList();
    l1->push_back("is");
    l1->push_back("a");
    l1->push_back("demo");
    l1->print();
    l1->reverse();
}

/*
** REVERSE LL
if node stores add of next node change to store add of previous node
so track of prev & curr node is required but when curr points to the prev node right side ll can be lost so access it through out pointer as nex pointer
 */