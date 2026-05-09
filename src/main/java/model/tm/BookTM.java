package model.tm;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString

public class BookTM {
    private String id;
    private String title;
    private String author;
    private String genre;
    private Double price;

    public BookTM(String id, String title, String author, String genre, Double price){
        this.id=id;
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.price=price;
    }
}
