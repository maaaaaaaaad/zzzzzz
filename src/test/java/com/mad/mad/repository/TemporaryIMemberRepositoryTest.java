package com.mad.mad.repository;


import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.IMemberRepository;
import com.mad.mad.domain.repository.TemporaryIMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TemporaryIMemberRepositoryTest {

    private IMemberRepository repository;
    private Member member;

    private final String mockUserName = "mad";

    @BeforeEach
    public void beforeEach() {
        this.repository = new TemporaryIMemberRepository();
        this.member = new Member();
    }

    @AfterEach
    public void afterEach() {
        this.repository.clearStore();
    }


    @Test
    public void findByName() {
        member.setName(this.mockUserName);
        Member member1 = repository.save(member);
        assertThat(this.mockUserName).isEqualTo(member1.getName());
    }

    @Test
    public void save() {
        member.setName(this.mockUserName);
        Member result = repository.save(member);
        long id = result.getId();
        assertThat(id).isEqualTo(1);
        assertThat(id).isNotZero();
        assertThat(id).isNotNull();
    }
}
