package com.mad.mad.repository;


import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.MemberRepository;
import com.mad.mad.domain.repository.TemporaryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemporaryMemberRepositoryTest {

    MemberRepository repository = new TemporaryMemberRepository();

    @Test()
    public void save() {
        Member member = new Member();
        member.setName("mad");
        repository.save(member);
        Member result = repository.findByName(member.getName()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }
}
