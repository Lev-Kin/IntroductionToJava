package u05oop.tasks.file;

import java.util.ArrayList;

public class Directory {
    private String name;
    private ArrayList<TextFile> files;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<TextFile> getFiles() {
        return files;
    }

    public void addTextFile(TextFile textFile) {
        this.files.add(textFile);
    }

    public void changeDirectoryName(String name) {
        this.name = name;
    }

    public void removeFile(String name) {
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getNameFile().equalsIgnoreCase(name))
                files.remove(i);
        }
    }
}
