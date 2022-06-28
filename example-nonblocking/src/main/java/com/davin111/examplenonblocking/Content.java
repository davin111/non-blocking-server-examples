package com.davin111.examplenonblocking;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("content")
@Getter
public class Content {
    @Id
    private Long id;

    private String name;

    private Boolean isPremium;

    private String imageUrl;

    private String videoUrl;
}
