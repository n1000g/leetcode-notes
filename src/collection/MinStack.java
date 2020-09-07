package collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: 155.设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。 
 *
 * @author: n8g
 * @createDate: 2020/9/7
 */
public class MinStack {

    private Deque<Integer> s;
    private Deque<Integer> minS;
    /** initialize your data structure here. */
    public MinStack() {
        s = new LinkedList<>();
        minS = new LinkedList<>();
        minS.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        s.push(x);
        if (x <= minS.peek())
            minS.push(x);
    }

    public void pop() {
        if (s.peek().equals(minS.peek()))
            minS.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
