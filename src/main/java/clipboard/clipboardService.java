package clipboard;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class clipboardService {

    private final clipboardReader reader;
    private final clipboardHistory history;
    private final clipboardWatcher watcher;

    public clipboardService(int historySize) {
        this.reader = new clipboardReader();
        this.history = new clipboardHistory(historySize);
        this.watcher = new clipboardWatcher(reader, history);
    }

    public void start() throws NativeHookException {
        // Start clipboard watcher thread
        new Thread(watcher::watcher).start();

        // Register global keyboard hook
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(
                new GlobalShortcutListener(reader, history)
        );

        System.out.println("Clipboard service started");
    }

    public void stop() throws NativeHookException {
        GlobalScreen.unregisterNativeHook();
        System.out.println("Clipboard service stopped");
    }
}
