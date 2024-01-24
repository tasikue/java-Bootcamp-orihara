package advanced.aggregation.composition.entity;

/**
 * 書籍クラス
 */
public class Book {
    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public void showDetails(){
        System.out.format("タイトル: %-20s, 著者: %s \n", this.title, this.author);
    }
}
