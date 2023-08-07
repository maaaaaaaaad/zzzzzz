package com.mad.mad.repository;


import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.MemberRepository;
import com.mad.mad.domain.repository.TemporaryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemporaryMemberRepositoryTest {
    final String testName = "mad";
    MemberRepository repository = new TemporaryMemberRepository();
    Member member = new Member();

    @Test()
    public void save() {
        this.member.setName(this.testName);
        repository.save(this.member);
        Member resultById = repository.findById(this.member.getId()).get();
        Assertions.assertThat(this.member).isEqualTo(resultById);
        Assertions.assertThat(resultById.getId()).isEqualTo(1L);
        Assertions.assertThat(resultById.getId()).isNotZero();
        Member resultByName = repository.findByName(this.member.getName()).get();
        Assertions.assertThat(this.member).isEqualTo(resultByName);
        Assertions.assertThat(resultByName.getName()).isEqualTo(this.testName);
        Assertions.assertThat(resultByName.getName()).isNotEmpty();
    }
}
