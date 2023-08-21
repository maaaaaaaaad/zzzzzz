package com.mad.mad.config;

import com.mad.mad.domain.repository.IMemberRepository;
import com.mad.mad.domain.repository.TemporaryIMemberRepository;
import com.mad.mad.domain.service.IMemberService;
import com.mad.mad.domain.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeenConfig {

    @Bean
    public IMemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public IMemberRepository memberRepository() {
        return new TemporaryIMemberRepository();
    }
}
