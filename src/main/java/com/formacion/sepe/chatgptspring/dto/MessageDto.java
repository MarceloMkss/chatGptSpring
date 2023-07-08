package com.formacion.sepe.chatgptspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageDto {

    private String role;
    private String content;

}
