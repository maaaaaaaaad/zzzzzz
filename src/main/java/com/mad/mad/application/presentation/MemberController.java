package com.mad.mad.application.presentation;

import com.mad.mad.domain.entity.Member;
import com.mad.mad.domain.service.IMemberService;
import com.mad.mad.domain.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController()
public class MemberController {

    private static final IMemberService service = new MemberService();

    @GetMapping("/")
    @ResponseBody
    public Member join(@RequestBody() Member member) {
        return service.join(member);
    }
}
