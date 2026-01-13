import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class clipboardReader {
    private final Clipboard clipboard;

    clipboardReader() {

        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public String readText(){
        Transferable data = clipboard.getContents(null);

        if (data != null && data.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {

                return   (String) data.getTransferData(DataFlavor.stringFlavor);

            }
            catch (UnsupportedFlavorException | IOException e ) {
                e.printStackTrace();
            }

        }
        return  null;
    }

}

