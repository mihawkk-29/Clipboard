package clipboard;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class GlobalShortcutListener implements NativeKeyListener {

    private final clipboardReader reader;
    private final clipboardHistory history;

    public GlobalShortcutListener(clipboardReader reader,
                                  clipboardHistory history) {
        this.reader = reader;
        this.history = history;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {

        boolean ctrl =
                (e.getModifiers() & NativeKeyEvent.CTRL_L_MASK) != 0 ||
                        (e.getModifiers() & NativeKeyEvent.CTRL_R_MASK) != 0;

        boolean shift =
                (e.getModifiers() & NativeKeyEvent.SHIFT_L_MASK) != 0 ||
                        (e.getModifiers() & NativeKeyEvent.SHIFT_R_MASK) != 0;

        // Ctrl + Shift + C
        if (ctrl && shift && e.getKeyCode() == NativeKeyEvent.VC_C) {
            handleCopy();
        }
        // Ctrl + Shift + V
        if (ctrl && shift && e.getKeyCode() == NativeKeyEvent.VC_V) {
            handlePaste();
        }
        if(ctrl && shift && e.getKeyCode() == NativeKeyEvent.VC_F){
            history.clear();
            reader.ignoreNextCopy();
        }

    }

    private void handleCopy() {
        try {
            Thread.sleep(50); // Linux clipboard delay
        } catch (InterruptedException ignored) {}

        String text = reader.readText();
        if (text != null && !text.isBlank()) {
            history.add(text);
            System.out.println(text);
        }
    }
    public void handlePaste(){
        String text= history.getNext();
        if(text == null){
            return;
        }
        clipboardWriter.write(text);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {}

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {}
}
