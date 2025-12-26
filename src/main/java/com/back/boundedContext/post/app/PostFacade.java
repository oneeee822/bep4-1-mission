package com.back.boundedContext.post.app;

import com.back.boundedContext.post.domain.Post;
import com.back.boundedContext.post.domain.PostMember;
import com.back.global.rsData.RsData;
import com.back.shared.post.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostFacade {
    private final PostWriteUseCase postWriteUseCase;
    private final PostSyncMemberUseCase postSyncMemberUseCase;
    private final PostSupport postSupport;

    public long count() {
        return postSupport.count();
    }

    @Transactional
    public RsData<Post> write(PostMember author, String title, String content) {
        return postWriteUseCase.write(author,title,content);
    }

    public Optional<Post> findById(int id) {
        return postSupport.findById(id);
    }

    @Transactional
    public PostMember syncMember(MemberDto member) {
        return postSyncMemberUseCase.save(member);
    }

    public Optional<PostMember> findMemberByUsername(String username) {
        return postSupport.findMemberByUsername(username);
    }
}
