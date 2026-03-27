package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Data
public class CustomerRegistration {
    private String id;
    private String title;
    private String name;
    private String telNumber;
}
