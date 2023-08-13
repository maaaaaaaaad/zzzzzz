package com.mad.mad.service;

import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.repository.IMemberRepository;
import com.mad.mad.domain.repository.TemporaryIMemberRepository;
import com.mad.mad.domain.service.IMemberService;
import com.mad.mad.domain.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    private IMemberService service;
    private IMemberRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new TemporaryIMemberRepository();
        service = new MemberService(repository);
    }

    Member member = new Member();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test()
    public void join() {
        this.member.setName("mad");
        final String mad = this.member.getName();
        final Member result = this.service.join(this.member);
        Assertions.assertThat(result.getName()).isEqualTo(mad);
        final Error error = org.junit.jupiter.api.Assertions.assertThrows(Error.class, () -> this.service.join(this.member));
        Assertions.assertThat(error.getMessage()).isEqualTo("name");
    }
}
