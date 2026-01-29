package clipboard;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

public class clipboardReader {

    private final Clipboard clipboard;
    private volatile boolean ignoreNext = false;

    public clipboardReader() {
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }


    public void ignoreNextCopy() {
        ignoreNext = true;
    }

    public String readText() {
        if (ignoreNext) {
            ignoreNext = false;
            return null;
        }

        Transferable data = clipboard.getContents(null);

        if (data != null && data.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                return (String) data.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ignored) {
                // normal on Linux
            }
        }
        return null;
    }
}
