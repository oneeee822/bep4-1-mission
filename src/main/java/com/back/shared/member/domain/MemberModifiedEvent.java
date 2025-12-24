package com.back.shared.member.domain;

import com.back.shared.post.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberModifiedEvent {
    private final MemberDto member;
}
