package com.mad.mad.domain.service;

import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.IMemberRepository;

import java.util.Optional;

public class MemberService implements IMemberService {

    private final IMemberRepository repository;

    public MemberService(IMemberRepository memberRepository) {
        this.repository = memberRepository;
    }

    private Optional<Member> memberName(Member member) {
        return this.repository.findByName(member.getName());
    }

    @Override
    public final Member join(Member member) {
        Optional<Member> name = memberName(member);
        name.ifPresent((data) -> {
            throw new Error("name");
        });
        return this.repository.save(member);
    }
}
