package com.mad.mad.application.presentation;

import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.service.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class MemberController {

    private final IMemberService service;

    public MemberController(IMemberService service) {
        this.service = service;
    }

    @PostMapping("/")
    public Member join(@RequestBody() Member member) {
        try {
            return this.service.join(member);
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "name")) {
                throw new IllegalArgumentException("name");
            }
            throw new RuntimeException(e);
        }
    }
}

