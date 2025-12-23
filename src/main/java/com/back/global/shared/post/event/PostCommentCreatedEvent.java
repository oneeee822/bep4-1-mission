package com.back.global.shared.post.event;


import com.back.global.shared.post.dto.PostCommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostCommentCreatedEvent {
    private final PostCommentDto postComment;
}
