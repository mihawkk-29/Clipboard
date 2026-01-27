package clipboard;

public class clipboardWatcher {
    private clipboardReader reader;
    private clipboardHistory history;
    private String lastText;


    public clipboardWatcher(clipboardReader reader,clipboardHistory history) {
        this.reader = reader;
        this.history = history;
    }

    public void  watcher(){
        while(true){
            try {
                String currentText = reader.readText();

                if(currentText!=null && !currentText.equals(lastText)){
                    history.add(currentText);
                    lastText = currentText;
                }

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }
}
