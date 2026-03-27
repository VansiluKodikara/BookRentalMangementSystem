package org.example.tm;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CustomerTM {
    private String id;
    private String title;
    private String name;
    private String telNumber;

    public CustomerTM(String id,String title,String name,String telNumber){
        this.id=id;
        this.title=title;
        this.name=name;
        this.telNumber=telNumber;
    }
}
