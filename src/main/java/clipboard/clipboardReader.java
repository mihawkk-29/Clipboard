package clipboard;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class clipboardReader {
    private final Clipboard clipboard;

   public  clipboardReader() {

        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public String readText() {
        Transferable data = clipboard.getContents(null);

        if (data != null && data.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                return (String) data.getTransferData(DataFlavor.stringFlavor);

            } catch (UnsupportedFlavorException | IOException ignored) {
                // Normal on Linux when clipboard holds non-text data
            }
        }
        return null;
    }


}

