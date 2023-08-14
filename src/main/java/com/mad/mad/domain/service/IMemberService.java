package com.mad.mad.domain.service;

import com.mad.mad.domain.entity.Member;

import java.util.List;

public interface IMemberService {
    Member join(Member member);
    List<Member> members();
}
