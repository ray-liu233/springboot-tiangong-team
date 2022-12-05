package com.tg.team.controller;

import com.tg.team.dto.AddMemberRequest;
import com.tg.team.entity.Member;
import com.tg.team.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(path = "/POST/members")
    @ResponseStatus(value= HttpStatus.CREATED)
    public @ResponseBody Member addMembers(@RequestBody AddMemberRequest request){
        Member member = memberService.addMembers(request);
        System.out.println(Objects.nonNull(member));
        System.out.println(member.getName());
        System.out.println(member.getMemberType());
        return member;
    }

    @GetMapping(path ="/GET/members")
    public List<Member> getAllMembers(){
        return memberService.findMembers();
    }


}
