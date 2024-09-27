package org.example.bookonline.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;

    private String name;

    private String cover;

    private String author;
    //  简介
    private String introduction;
    //  出版社
    private String house;
    //  出版年
    private String year;
    //  页数
    private Integer page;
    //  定价
    private String price;
    //  丛书
    private String collection;
    //  ISBN
    private String ISBN;
}
