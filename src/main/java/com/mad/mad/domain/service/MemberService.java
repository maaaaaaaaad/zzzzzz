package com.mad.mad.domain.service;

import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.IMemberRepository;
import com.mad.mad.domain.repository.TemporaryIMemberRepository;

import java.util.Optional;

public class MemberService implements IMemberService {

    private final IMemberRepository repository;

    public MemberService(IMemberRepository memberRepository) {
        this.repository = memberRepository;
    }

    private void conflictCheckMember(Member member) {
        this.repository.findByName(member.getName()).ifPresent(query -> {
            throw new Error("name");
        });
    }

    @Override
    public final Member join(Member member) {
        conflictCheckMember(member);
        return this.repository.save(member);
    }
}
