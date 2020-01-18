package org.guo.leetCode;

class MinStack {
    
    int[] element = new int[100];
    int topIndex = -1;
    int minIndex = 0;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (topIndex + 1 >= element.length) {
            int[] tmp = new int[element.length * 2];
            System.arraycopy(element, 0, tmp, 0, element.length);
            element = tmp;
        }
        element[++topIndex] = x;
        if (x < element[minIndex]) {
            minIndex = topIndex;
        }       
    }
    
    public void pop() {
        if (minIndex == topIndex) {
            int tmp = Integer.MAX_VALUE;
            for (int i = 0; i < topIndex; i++) {
                if (element[i] <= tmp) {
                    tmp = element[i];
                    minIndex = i;
                }
            }
        }
        element[topIndex--] = -1;
    }
    
    public int top() {
        return element[topIndex];
    }
    
    public int getMin() {
        return element[minIndex];
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-2147483648);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */