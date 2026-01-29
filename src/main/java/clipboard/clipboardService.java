package clipboard;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class clipboardService {

    private final clipboardReader reader;
    private final clipboardHistory history;

    public clipboardService(int historySize) {
        this.reader = new clipboardReader();
        this.history = new clipboardHistory(historySize);
    }

    public void start() throws NativeHookException {

      

        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(
                new GlobalShortcutListener(reader, history)
        );

        System.out.println("Clipboard service started");
    }
}
