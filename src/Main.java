import java.awt.*;
import java.awt.datatransfer.Clipboard;

class Main{
    public static void main(String[] args) {
        clipboardReader reader = new clipboardReader();
        clipboardWatcher watcher = new clipboardWatcher(reader);
        watcher.watcher();
    }
}