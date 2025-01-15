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

    // mid LL
    void *mid()
    {
        if (head == NULL)
        {
            cout << "sorry ll is null";
            return 0;
        }
        else
        {
            Node *slow = head;
            Node *fast = head;
            while (fast != NULL && fast->next != NULL)
            {
                slow = slow->next;
                fast = fast->next->next;
            }
            cout << slow->val;
        }
    }
};
int main()
{
    NodeList *l1 = new NodeList();
    l1->push_back("is");
    l1->push_back("a");
    l1->push_back("demo");
    l1->push_back("of");
    l1->print();
    l1->mid();
}

/*
** mid of  LL
mid = half of total right
slow & fast
 */