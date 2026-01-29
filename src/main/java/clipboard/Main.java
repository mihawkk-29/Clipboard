package clipboard;

import com.github.kwhat.jnativehook.GlobalScreen;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {

        Logger logger =
                Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);

        clipboardService service = new clipboardService(100);
        service.start();

        System.out.println("Running... Ctrl + Shift + C / V");
        Thread.currentThread().join();
    }
}
