package clipboard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class clipboardHistory {

    private final int maxsize;
    private final Deque<String> dq = new ArrayDeque<>();
    private int cursor = 0;

    public clipboardHistory(int maxsize) {
        this.maxsize = maxsize;
    }

    public synchronized void add(String text) {
        if (!dq.isEmpty() && dq.peekFirst().equals(text)) {
            return;
        }

        dq.addFirst(text);

        if (dq.size() > maxsize) {
            dq.removeLast();
        }

        cursor = 0;
    }


    public synchronized String getNext() {
        if (dq.isEmpty()) {
            return null;
        }

        if (cursor >= dq.size()) {
            return null;
        }

        Iterator<String> it = dq.iterator();
        for (int i = 0; i < cursor; i++) {
            it.next();
        }

        String result = it.next();
        cursor++;
        return result;
    }


}
