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
    private String telephoneNum;

    public CustomerTM(String id, String title, String name, String telephoneNum) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.telephoneNum = telephoneNum;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }
}
