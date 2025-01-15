#include <iostream>
using namespace std;
class Node
{
public:
    int data;
    Node *pre;
    Node *next;
    Node(int val)
    {
        data = val;
        pre = NULL;
        next = NULL;
    }
};
class NodeList
{
public:
    Node *head;
    Node *tail;
    int size;
    NodeList()
    {
        size = 0;
        head = NULL;
        tail = NULL;
    }
    // push_front
    void push_front(int val)
    {
        size++;
        Node *node = new Node(val);
        // empty
        if (head == NULL)
        {
            head = tail = node;
        }
        else
        { // non-empty
            node->next = head;
            head->pre = node;
            head = node;
        }
    }
    // push_back
    void push_back(int val)
    {
        size++;
        Node *node = new Node(val);
        // empty
        if (head == NULL)
        {
            head = tail = node;
        }
        else
        {
            tail->next = node;
            node->pre = tail;
            tail = node;
        }
        // non-empty
    }
    // insert_pos
    void insert_pos(int val, int pos)
    {
        if (head == NULL)
        {
            cout << "sorry there no element present in LL";
        }
        else
        {
            if (pos < 0)
            {
                cout << "sorry negative pos";
            }
            else if (pos == 0)
            {
                push_front(val);
            }
            else
            {
                size++;
                Node *node = new Node(val);
                Node *temp = head;
                for (int i = 0; i < pos; i++)
                {
                    if (temp == NULL)
                    {
                        cout << "sorry invalid pos";
                        return;
                    }
                    temp = temp->next;
                }
                node->next = temp->next;
                temp->next->pre = node;
                node->pre = temp;
                temp->next = node;
            }
        }
    }
    // remove_pos
    void remove_pos(int pos)
    {
        if (head == NULL)
        {
            cout << "sorry LL is empty";
        }
        else
        {
            if (pos < 0)
            {
                cout << "sorry negative pos";
            }
            else if (pos == 0)
            {
                pop_front();
            }
            else
            {
                Node *temp = head;
                for (int i = 0; i < pos; i++)
                {
                    if (temp == NULL)
                    {
                        cout << "sorry invalid pos";
                        return;
                    }
                    temp = temp->next;
                }
                Node *temp2 = temp->next;
                if (temp2->next != NULL)
                {
                    temp2->next->pre = temp;
                    temp->next = temp2->next;
                }
                else
                {
                    temp->next = NULL;
                }
                size--;
                delete temp2;
            }
        }
    }
    // pop_front
    void pop_front()
    {
        if (head == NULL)
        {
            cout << "sorry LL is empty";
        }
        else
        {
            Node *temp = head;

            if (head == tail)
            {
                head = tail = NULL;
            }
            else
            {
                head = head->next;
                head->pre = NULL;
                temp->next = NULL;
            }
            size--;
            delete temp;
        }
    }
    // pop_back
    void pop_back()
    {
        if (head == NULL)
        {
            cout << "sorry LL is empty";
        }
        else
        {
            Node *temp = tail;
            if (head == tail)
            {
                head = NULL;
                tail = NULL;
            }
            else
            {
                tail = tail->pre;
                tail->next = NULL;
                temp->pre = NULL;
            }
            size--;
            delete temp;
        }
    }
    // print
    void print()
    {
        if (head == NULL)
        {
            cout << "sorry LL is empty";
        }
        else
        {
            Node *temp = head;
            while (temp != NULL)
            {
                cout << temp->data << "->";
                temp = temp->next;
            }
            cout << "\n";
        }
    }
    void length()
    {
        if (size != 0)
        {
            cout << size;
        }
        else
        {
            cout << "sorry the LL is empty" << endl;
        }
    }
};
int main()
{
    NodeList *l1 = new NodeList();
    l1->push_front(263);
    l1->push_back(345);
    l1->pop_front();
    l1->push_front(26);
    l1->push_front(34);
    l1->pop_back();
    l1->insert_pos(11, 0);

    l1->print();
    l1->length();
    l1->remove_pos(1);
    l1->print();
    return 0;
}