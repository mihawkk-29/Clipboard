package clipboard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class clipboardHistory {

    private final int maxSize;
    private final Deque<String> deque = new ArrayDeque<>();
    private int cursor = 0;

    public clipboardHistory(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void add(String text) {
        if (text == null || text.isBlank()) {
            return;
        }

        if (!deque.isEmpty() && deque.peekFirst().equals(text)) {
            return;
        }

        deque.addFirst(text);

        if (deque.size() > maxSize) {
            deque.removeLast();
        }

        cursor = 0;
    }
    public synchronized void clear() {
        deque.clear();
        cursor = 0;
        System.out.println("CLIPBOARD HISTORY CLEARED");
    }


    public synchronized String getNext() {
        if (deque.isEmpty()) {
            return null;
        }

        if (cursor >= deque.size()) {
            cursor = 0;
        }

        Iterator<String> it = deque.iterator();
        for (int i = 0; i < cursor; i++) {
            it.next();
        }

        String result = it.next();
        cursor++;
        return result;
    }
}
