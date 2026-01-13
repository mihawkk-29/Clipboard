public class clipboardWatcher {
    private clipboardReader reader;
    private String lastText;


    public clipboardWatcher(clipboardReader reader) {
        this.reader = reader;
    }

    public void  watcher(){
        while(true){
            try {
                String currentText = reader.readText();

                if(currentText!=null && !currentText.equals(lastText)){
                    System.out.println(currentText);
                    lastText = currentText;
                }

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }
}
