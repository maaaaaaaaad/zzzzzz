package com.mad.mad.repository;


import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.MemberRepository;
import com.mad.mad.domain.repository.TemporaryMemberRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TemporaryMemberRepositoryTest {

    MemberRepository repository = new TemporaryMemberRepository();
    Member member = new Member();

    @Test()
    public void findByName() {
        final String name = member.getName();
        Optional<Member> result = repository.findByName(name);
        assertThat(name).isNotEqualTo(result);

        final String mad = "mad";
        member.setName(mad);
        Member member1 = repository.save(member);
        assertThat(mad).isEqualTo(member1.getName());
    }

    @Test()
    public void save() {
        Member result = repository.save(member);
        long id = result.getId();
        assertThat(id).isEqualTo(1);
        assertThat(id).isNotZero();
        assertThat(id).isNotNull();
    }
}
