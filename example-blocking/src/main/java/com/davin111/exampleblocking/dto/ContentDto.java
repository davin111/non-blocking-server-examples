package com.davin111.exampleblocking.dto;

import com.davin111.exampleblocking.Content;
import lombok.Data;

@Data
public class ContentDto {
    private Long id;

    private String name;

    private Boolean isPremium;

    private String imageUrl;

    private String videoUrl;

    public ContentDto(Content content) {
        id = content.getId();
        name = content.getName();
        isPremium = content.getIsPremium();
        imageUrl = content.getImageUrl();
        videoUrl = content.getVideoUrl();
    }
}
