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

import java.util.LinkedList;
import java.util.List;

public class MemberServiceUnitTest {

    private IMemberService service;
    private IMemberRepository repository;
    private final LinkedList<Member> members = new LinkedList<>();

    @BeforeEach
    public void beforeEach() {
        repository = new TemporaryIMemberRepository();
        service = new MemberService(repository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
        this.members.clear();
    }

    @Test()
    public void join() {
        Member member = new Member();
        String mockUserName = "mad";
        member.setName(mockUserName);
        final String mad = member.getName();
        final Member result = this.service.join(member);
        Assertions.assertThat(result.getName()).isEqualTo(mad);
        final Error error = org.junit.jupiter.api.Assertions.assertThrows(Error.class, () -> this.service.join(member));
        Assertions.assertThat(error.getMessage()).isEqualTo("name");
    }

    @Test()
    public void members() {
        for (int i = 0; i < 100; i++) {
            Member member = new Member();
            member.setName(String.format("mad%d", i + 1));
            this.service.join(member);
            this.members.push(member);
        }
        final List<Member> result = this.service.members();
        final int membersSize = this.members.size();
        Assertions.assertThat(result.size()).isEqualTo(membersSize);
    }
}
