package com.back.boundedContext.member.app;

import com.back.boundedContext.member.domain.Member;
import com.back.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberFacade {
    private final MemberJoinUseCase memberJoinUserCase;
    private final MemberSupport memberSupport;
    private final MemberGetRandomSecureTipUseCase memberGetRandomSecureTipUseCase;

    public long count() {
        return memberSupport.count();
    }

    @Transactional
    public RsData<Member> join(String username, String password, String nickname) {
        return memberJoinUserCase.join(username, password, nickname);
    }

    public Optional<Member> findByUsername(String username) {
        return memberSupport.findByUsername(username);
    }

    public Optional<Member> findById(int id) {
        return memberSupport.findById(id);
    }

    public String getRandomSecureTip(){
        return memberGetRandomSecureTipUseCase.getRandomSecureTip();
    }
}