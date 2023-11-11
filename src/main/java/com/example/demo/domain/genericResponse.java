package com.example.demo.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class genericResponse {
    private boolean flag;
    private String message;
    private int statusCode;
}
