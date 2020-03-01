package com.dirk.spring.dataflowprocessor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheData {
    private int id;
    private String name;
    private int price;
}
