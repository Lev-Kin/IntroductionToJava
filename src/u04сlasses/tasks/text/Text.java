package u04сlasses.tasks.text;

import java.util.ArrayList;

public class Text {
    private Word title;
    private ArrayList<Sentence> text;

//    public Text(Word title) {
//        this.title = title;
//        this.text = new ArrayList<>();
//    }

//    public Text(Word title, ArrayList<Sentence> text) {
//        this.title = title;
//        this.text = text;
//    }

    public Text(Word title, Sentence sentence) {
        this.title = title;
        this.text = new ArrayList<>();
        this.text.add(sentence);
    }

    public void setTitle(Word title) {
        this.title = title;
    }

    public Word getTitle() {
        return this.title;
    }

    public void addSentence (Sentence sentence){
        this.text.add(sentence);
    }

    public void printTitle(){
        System.out.println(title);
    }

    public void print(){
        for(Sentence sentence : this.text){
            System.out.println(sentence);
        }
    }
}