package com.back.boundedContext.market.app;

import com.back.boundedContext.market.domain.MarketMember;
import com.back.shared.post.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketFacade {
    private final MarketSyncMemberUseCase marketSyncMemberUsecase;

    public MarketMember syncMember(MemberDto member){
        return marketSyncMemberUsecase.syncMember(member);
    }
}
