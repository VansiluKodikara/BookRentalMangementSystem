package org.example.model.tm;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString

public class CustomerTM {
    private String id;
    private String title;
    private String name;
    private String telNum;

    public CustomerTM(String id, String title, String name, String telNum) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.telNum = telNum;
    }

    public String getTelephoneNum() {
        return telNum;
    }
}
