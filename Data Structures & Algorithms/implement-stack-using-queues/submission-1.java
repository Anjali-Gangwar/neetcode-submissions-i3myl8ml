class MyStack {
    Queue<Integer> queue;
    Queue<Integer> queue2;

    public MyStack() {
        queue = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue2.add(x);
        while (!queue.isEmpty()) {
            queue2.add(queue.remove());
        }

        var temp = queue;
        queue = queue2;
        queue2 = temp;
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */