package com.mad.mad.domain.service;

import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.IMemberRepository;
import com.mad.mad.domain.repository.TemporaryIMemberRepository;

import java.util.Optional;

public class MemberService implements IMemberService {

    private final IMemberRepository repository = new TemporaryIMemberRepository();

    @Override
    public final Member join(Member member) {
        Optional<Member> name = this.repository.findByName(member.getName());
        name.ifPresent(query -> {
            throw new Error("name");
        });
        return this.repository.save(member);
    }
}
