package advent_2023.twenty;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Stack<T> {

    public void addAll(List<? extends T> pulses) {
        for (T pulse : pulses) {
            push(pulse);
        }
    }

    class Element {
        private final int cnt;
        private final T value;

        Element(int cnt, T value) {
            this.cnt = cnt;
            this.value = value;
        }
    }

    private int cnt;

    private PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cnt));

    public Stack() {
        cnt = 0;
    }

    public void push(T value) {
        cnt++;
        pq.offer(new Element(cnt, value));
    }

    public T pop() {
        if (pq.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        cnt--;
        return pq.poll().value;
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }
}
