package com.mad.mad.service;

import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.service.IMemberService;
import com.mad.mad.domain.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    IMemberService service = new MemberService();
    Member member = new Member();

    @Test()
    public void join() {
        this.member.setName("mad");
        final String mad = this.member.getName();
        final Member result = this.service.join(this.member);
        Assertions.assertThat(result.getName()).isEqualTo(mad);
    }
}
