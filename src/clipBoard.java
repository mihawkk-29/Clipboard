import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class clipBoard {

    clipBoard() {

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //System.out.println("Clipboard Connected");
        Transferable data = clipboard.getContents(null);

        if (data != null && data.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {

                String text = (String) data.getTransferData(DataFlavor.stringFlavor);
                System.out.println(text);
            }
            catch (UnsupportedFlavorException | IOException e ) {
                e.printStackTrace();
            }
        }
    }
}

