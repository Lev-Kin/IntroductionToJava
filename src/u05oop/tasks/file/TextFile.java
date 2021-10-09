package u05oop.tasks.file;

public class TextFile extends File {

    private Text text;

    public TextFile(Directory directory, String nameFile) {
        super(directory, nameFile);
        this.text = new Text("");
        super.getDirectory().addTextFile(this);
    }

    public void addText(String str) {
        text.addText(str);
    }

    public void printText() {
        System.out.println(text.getText());
    }

    @Override
    public void changeName(String nameFile) {
        this.setNameFile(nameFile);
    }
}
