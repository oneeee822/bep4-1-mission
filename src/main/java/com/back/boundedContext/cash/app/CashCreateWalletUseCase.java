package com.back.boundedContext.cash.app;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.boundedContext.cash.out.WalletRepository;
import com.back.shared.cash.dto.CashMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CashCreateWalletUseCase {
    private final WalletRepository walletRepository;
    private final CashMemberRepository cashMemberRepository;

    public Wallet createWallet(CashMemberDto member) {
        CashMember _member = cashMemberRepository.getReferenceById(member.getId()); //얘는 JPA에서 select문을 안 날림.
        Wallet wallet = new Wallet(_member);

        return walletRepository.save(wallet);
    }
}
