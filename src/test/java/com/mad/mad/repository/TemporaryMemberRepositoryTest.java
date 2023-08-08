package com.mad.mad.repository;


import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.MemberRepository;
import com.mad.mad.domain.repository.TemporaryMemberRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TemporaryMemberRepositoryTest {
    final String testName = "mad";
    MemberRepository repository = new TemporaryMemberRepository();
    Member member = new Member();


    @Test()
    public void findById() {
        Optional<Member> empty = repository.findById(1000L);
        assertThat(empty).isEmpty();
    }

    @Test()
    public void findByName() {
        Optional<Member> empty = repository.findByName(this.testName);
        assertThat(empty).isEmpty();
    }

    @Test()
    public void save() {
        this.member.setName(this.testName);
        repository.save(this.member);
        Member resultById = repository.findById(this.member.getId()).get();
        assertThat(this.member).isEqualTo(resultById);
        assertThat(resultById.getId()).isEqualTo(1L);
        assertThat(resultById.getId()).isNotZero();
        Member resultByName = repository.findByName(this.member.getName()).get();
        assertThat(this.member).isEqualTo(resultByName);
        assertThat(resultByName.getName()).isEqualTo(this.testName);
        assertThat(resultByName.getName()).isNotEmpty();
    }

}
