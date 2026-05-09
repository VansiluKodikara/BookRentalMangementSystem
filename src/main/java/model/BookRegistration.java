package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookRegistration {
    private String id;
    private String title;
    private String author;
    private String genre;
    private Double price;
}
