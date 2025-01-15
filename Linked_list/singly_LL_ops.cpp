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
    // push front
    void push_front(string data)
    {
        // creation of node
        Node *node = new Node(data);
        if (head != NULL)
        { // connecting with linked list
            node->next = head;
            head = node;
            // move head pointer
        }
        else // for empty LL
        {
            head = tail = node;
        }
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
    // pop front
    void pop_front()
    {
        //
        if (head == NULL)
        {
            cout << "LL is NULL";
        }
        else
        {
            Node *temp = head;
            head = head->next;
            temp->next = NULL;
            delete temp;
        }
    }
    // pop back
    void pop_back()
    {
        if (head == NULL)
        {
            cout << "LL is NULL";
        }
        else
        {
            Node *temp = head;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = NULL;
            delete tail;
            tail = temp;
        }
    }
    // insert at pos
    void insert(string data, int pos)
    {

        if (pos == 0)
        {
            push_front(data);
        }
        else if (pos < 0)
        {
            cout << "negative position" << endl;
        }
        else
        {
            Node *node = new Node(data);
            Node *temp;
            temp = head;
            for (int i = 0; i < pos - 1; i++)
            {
                if (temp == NULL)
                {
                    cout << "not valid position";
                    return;
                }
                temp = temp->next;
            }
            node->next = temp->next;
            temp->next = node;
        }
    }
    // remove at pos
    void remove(int pos)
    {
        if (head == NULL)
        {
            cout << "LL is NULL";
        }
        else
        {
            if (pos == 0)
            {
                pop_front();
            }
            else if (pos < 0)
            {
                cout << "negative position" << endl;
            }
            else
            {
                Node *temp;
                temp = head;
                for (int i = 0; i < pos - 1; i++)
                {
                    if (temp == NULL)
                    {
                        cout << "not valid position";
                        return;
                    }
                    temp = temp->next;
                }
                temp->next = temp->next->next;
            }
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
                cout << temp->val << endl;
                temp = temp->next;
            }
        }
    }
};
int main()
{
    NodeList *l1 = new NodeList();
    l1->push_front("this");
    l1->push_back("is");
    l1->push_back("a");
    l1->push_back("LL");
    l1->insert("demo", 3);
    l1->print();
}