package com.back.boundedContext.post.app;

import com.back.boundedContext.member.domain.Member;
import com.back.boundedContext.post.domain.Post;
import com.back.boundedContext.post.domain.PostMember;
import com.back.boundedContext.post.out.PostMemberRepository;
import com.back.boundedContext.post.out.PostRepository;
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
    private final PostRepository postRepository;
    private final PostMemberRepository postMemberRepository;
    private final PostWriteUseCase postWriteUseCase;

    public long count() {
        return postRepository.count();
    }

    @Transactional
    public RsData<Post> write(Member author, String title, String content) {
        return postWriteUseCase.write(author,title,content);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public PostMember syncMember(MemberDto member) {
        PostMember postMember = new PostMember(
                member.getUsername(),
                "",
                member.getNickname()
        );

        postMember.setId(member.getId());
        postMember.setCreateDate(member.getCreateDate());
        postMember.setModifyDate(member.getModifyDate());

        return postMemberRepository.save(postMember);
    }
}
