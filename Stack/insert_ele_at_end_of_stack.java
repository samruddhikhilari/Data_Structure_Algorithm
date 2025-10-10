import java.util.Stack;

class insert_ele_at_end_of_stack {
    Stack<Integer> stack;

    public void create() {
        stack = new Stack<Integer>();
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);

        System.out.println(stack);
    }

    public void insertEnd(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        int topval = stack.pop();
        insertEnd(val);
        stack.push(topval);
    }

    public static void main(String[] args) {
        insert_ele_at_end_of_stack obj = new insert_ele_at_end_of_stack();
        obj.create();
        obj.insertEnd(10);
        System.out.println(obj.stack);
    }
}
/*
 * inserting ele at end of stack
 * 1.requires to remove all the ele from stack
 * 2. after removing all ele's push ele on the blank (empty)stack
 * 3.after adding ele at the bottom add that ele's which are removed from the
 * (in as it is ordered)
 * 
 * ? is after removing elements where to stored but dude don't worry about the
 * storage bcoz
 * at the stack uses into the recursion process same thing done there that is
 * store ele's in memory do operation & in return back flow access that mem
 * return back
 * simple we will use callstack approach
 * but instead of using callstack approach why not used directly the callstack
 * implementation i.e recursion.
 */