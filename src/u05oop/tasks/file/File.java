package u05oop.tasks.file;

abstract public class File {
    private Directory directory;
    private String nameFile;

    public File(Directory directory, String nameFile) {
        this.directory = directory;
        this.nameFile = nameFile;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    abstract public void changeName(String nameFile);

    @Override
    public String toString() {
        return nameFile;
    }
}
