package com.mad.mad.domain.service;

import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.MemberRepository;
import com.mad.mad.domain.repository.TemporaryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository repository = new TemporaryMemberRepository();

    public final Member join(Member member) {
        Optional<Member> name = this.repository.findByName(member.getName());
        name.ifPresent(query -> {
            throw new Error("name");
        });
        return this.repository.save(member);
    }
}
