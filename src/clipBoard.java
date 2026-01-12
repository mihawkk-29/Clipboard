import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class clipBoard {

    clipBoard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        System.out.println("Clipboard Connected");

        if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){

            String text = (String)
        }
    }
}
