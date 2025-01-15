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

public:
    NodeList()
    {
        head = NULL;
        tail = NULL;
    }
    // push front
    void push_front(int data)
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
                cout << temp->val << " -> ";
                temp = temp->next;
            }
        }
    }
    Node *getLL()
    {
        if (head == NULL)
        {
            cout << "LL is empty";
        }
        else
        {
            return head;
        }
        return NULL;
    }

    Node *findMid(Node *head)
    {
        Node *slow = head;
        Node *fast = head;
        // get mid +1 position
        while (fast != NULL && fast->next != NULL)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    Node *rev(Node *midPlus)
    {
        Node *prev = NULL;
        Node *curr = midPlus;
        Node *next = NULL;
        while (curr != NULL)
        {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    bool findPallindrome()
    {
        if (head == NULL)
        {
            cout << "LL is empty";
        }
        else
        {
            // find mid
            Node *mid = findMid(head);
            // reverse from mid
            Node *shead = rev(mid);
            // compare
            Node *temp = head;
            while (shead != NULL)
            {
                if (temp->val != shead->val)
                {
                    return false;
                }
                temp = temp->next;
                shead = shead->next;
            }
            return true;
        }
        return false;
    }
};

int main()
{
    NodeList *l1 = new NodeList();
    l1->push_back(11);
    l1->push_back(12);
    l1->push_back(13);
    l1->push_back(12);
    l1->push_back(11);
    l1->print();
    cout << l1->findPallindrome();
}