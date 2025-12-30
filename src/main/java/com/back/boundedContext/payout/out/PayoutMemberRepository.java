package com.back.boundedContext.payout.out;

import com.back.boundedContext.payout.domain.PayoutMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayoutMemberRepository extends JpaRepository<PayoutMember, Integer> {
    PayoutMember getReferencById(int id);
    Optional<PayoutMember> findByUsername(String holding);
}
