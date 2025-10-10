// after creating the doubly linked list

#include <iostream>
using namespace std;

Node *flatten(Node *head)
{
    if (head == NULL)
    {
        return NULL;
    }

    Node *curr = head;
    while (curr->!= NULL)
    {
        // if child DLL is present or not
        if (curr->child != NULL)
        {
            curr = curr->next;
        }
        else
        {
            // POINTING TO CHILD dll
            Node *Next = curr->next;
            curr->next = flatten(curr->child);
            curr->next->prev = curr;
            curr->child = NULL;

            // GETS END OF CHILD dll'S TAIL NODE
            while (curr->next != NULL)
            {
                curr = curr->next;
            }
            if (next == NULL)
            {
                curr = curr->next;
            }
            else
            {
                // if parent nodes present
                curr->next = Next;
                Next->prev = curr;
            }
        }
    }

    return head;
}
int main()
{
    Node *head = NULL;
    flatten(head);
    return 0;
}