package com.semi.community.web.dto;

import com.semi.community.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime updatedDate;

    public PostsListResponseDto(Posts enity) {
        this.id = enity.getId();
        this.title = enity.getTitle();
        this.author = enity.getAuthor();
        this.updatedDate = enity.getUpdatedDate();
    }
}
