import java.awt.*;
import java.awt.datatransfer.Clipboard;

class Main{
    public static void main(String[] args) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardReader reader = new clipboardReader(clipboard);
        String text = reader.readText();
        System.out.println(text);
    }
}