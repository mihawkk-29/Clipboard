package clipboard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class clipboardHistory {
    private int maxsize;
    private Deque<String> dq;
    private int cursor = 0;
    public clipboardHistory(int maxsize) {
        this.maxsize = maxsize;
        dq = new ArrayDeque<>();
    }

    public void add(String text) {
        if (!dq.isEmpty() && dq.getLast().equals(text)) {
            return;
        }

        dq.addFirst(text);


        if (dq.size() > maxsize) {
            dq.removeLast();
        }


    }

    public String getNext(){
        if(dq.isEmpty()){
            return null;
        }
        List<String> list = List.copyOf(dq);
        String next = list.get(cursor);
        cursor = (cursor + 1 ) % list.size();
        return next;
    }

    public String getRecent(){
        if(dq.isEmpty()) return null;
        return dq.getFirst();
    }
}
