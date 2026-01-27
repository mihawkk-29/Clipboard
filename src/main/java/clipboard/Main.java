package clipboard;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.Logger;


public final class Main {

    public static void main(String[] args) throws Exception {

        // Disable JNativeHook logs
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);

        clipboardReader reader = new clipboardReader();
        clipboardHistory history = new clipboardHistory(100);

        // Start clipboard watcher (optional but fine to keep)
        clipboardWatcher watcher = new clipboardWatcher(reader, history);
        new Thread(watcher::watcher).start();

        // Register global keyboard hook
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.err.println("Failed to register native hook");
            return;
        }

        GlobalScreen.addNativeKeyListener(
                new GlobalShortcutListener(reader, history)
        );

        System.out.println("Clipboard manager running...");
    }
}
