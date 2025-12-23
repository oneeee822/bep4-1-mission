package com.back.boundedContext.member.app;

import com.back.boundedContext.member.domain.Member;
import com.back.boundedContext.member.out.MemberRepository;
import com.back.global.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberFacade {
    private final MemberRepository memberRepository;
    private final MemberJoinUseCase memberJoinUserCase;

    public long count() {
        return memberRepository.count();
    }

    @Transactional
    public Member join(String username, String password, String nickname) {
        return memberJoinUserCase.join(username, password, nickname);
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public Optional<Member> findById(int id) {
        return memberRepository.findById(id);
    }
}