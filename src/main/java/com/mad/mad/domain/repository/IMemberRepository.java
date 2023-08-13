package com.mad.mad.domain.repository;

import com.mad.mad.domain.entity.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();

    void clearStore();

}
