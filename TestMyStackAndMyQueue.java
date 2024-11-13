public class TestMyStackAndMyQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(4);
         for (int num = 1; num <= 4; num++) {
            queue.enqueue(num);
            System.out.println(num + " is enqueued. Queue: head -> " + queue);
        }
        System.out.println();
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < 3; i++) {
            int item = queue.peek();
            stack.push(item);
            System.out.println(item + " is pushed. Stack: top -> " + stack);
            queue.dequeue();
            System.out.println(item + " is dequeued. Queue: head -> " + queue);
        }
        System.out.println();

        while (!stack.isEmpty()) {
            int item = stack.peek();
            System.out.println(stack.pop() + " is popped. Stack: top -> " + stack);
            queue.enqueue(item);
            System.out.println(item + " is enqueued. Queue: head -> " + queue);
            queue.enqueue(item);
            System.out.println(item + " is enqueued. Queue: head -> " + queue);
        }
    }
}