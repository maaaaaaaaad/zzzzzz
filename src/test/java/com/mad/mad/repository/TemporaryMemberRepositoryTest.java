package com.mad.mad.repository;


import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.TemporaryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TemporaryMemberRepositoryTest {

    TemporaryMemberRepository repository = new TemporaryMemberRepository();
    Member member = new Member();

    @AfterEach
    public void afterEach() {
        this.repository.clearStore();
    }


    @Test
    public void findByName() {
        final String mad = "mad";
        member.setName(mad);
        Member member1 = repository.save(member);
        assertThat(mad).isEqualTo(member1.getName());
    }

    @Test
    public void save() {
        Member result = repository.save(member);
        long id = result.getId();
        assertThat(id).isEqualTo(1);
        assertThat(id).isNotZero();
        assertThat(id).isNotNull();
    }
}
