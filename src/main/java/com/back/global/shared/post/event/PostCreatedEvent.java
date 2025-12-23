package com.back.global.shared.post.event;

import com.back.global.shared.post.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreatedEvent {
    private final PostDto post;
}
