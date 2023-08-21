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
    Member member = new Member();

    @BeforeEach
    public void beforeEach() {
        repository = new TemporaryIMemberRepository();
    }

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
