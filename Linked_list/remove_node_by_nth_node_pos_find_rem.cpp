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
    Node *head;
    Node *tail;
    int size;

public:
    NodeList()
    {
        size = 0;
        head = NULL;
        tail = NULL;
    }
    // push front
    void push_front(int data)
    {
        // creation of node
        Node *node = new Node(data);
        size++;
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
    void push_back(int data)
    {
        // create
        Node *node = new Node(data);
        size++;
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
            size--;
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
            size--;
            delete tail;
            tail = temp;
        }
    }
    // insert at pos
    void insert(int data, int pos)
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
            size++;
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
                size--;
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
                cout << temp->val << " -> ";
                temp = temp->next;
            }
        }
    }
    void removeNode(int n)
    {
        if (head == NULL)
        {
            cout << "sorry the LL is empty";
        }
        else
        {
            // size
            int pos = size - n;
            // find nth-1
            if (pos == 0)
            {
                pop_front();
            }
            else
            {
                if (pos < 0 || pos >= size)
                {
                    return;
                }
                Node *temp = head;
                for (int i = 1; i < pos; i++)
                {
                    temp = temp->next;
                }
                Node *dnode = temp->next;
                temp->next = dnode->next;
                size--;
                delete dnode;
            }
        }
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
    l1->removeNode(3);
    cout << endl;
    l1->print();
}