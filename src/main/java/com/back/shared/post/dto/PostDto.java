package com.back.shared.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDto {
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private int authorId;
    private String authorName;
    private String title;
    private String content;
}
