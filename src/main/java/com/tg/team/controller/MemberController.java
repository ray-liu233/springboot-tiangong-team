package com.tg.team.controller;

import com.tg.team.dto.AddMemberRequest;
import com.tg.team.entity.Member;
import com.tg.team.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(path = "/POST/members")
    @ResponseStatus(value= HttpStatus.CREATED)
    public Member addMembers(@RequestBody AddMemberRequest request){
        return memberService.addMembers(request);
    }

    @GetMapping(path ="/GET/members")
    public List<Member> getAllMembers(){
        return memberService.findMembers();
    }


}
