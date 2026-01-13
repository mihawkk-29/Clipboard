import java.util.ArrayDeque;
import java.util.Deque;

public class clipboardHistory {
    private int maxsize;
    private Deque<String> dq;

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
        String next = dq.removeLast();
        dq.addFirst(next);
        return next;
    }

    public String getRecent(){
        if(dq.isEmpty()) return null;
        return dq.getFirst();
    }
}
