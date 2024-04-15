package com.example.springsecuritytutorial.models;

import jdk.jfr.DataAmount;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserInfo {
    private String username;
    private String password;
}
