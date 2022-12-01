package com.tg.team.controller;

import com.tg.team.dto.AddMemberRequest;
import com.tg.team.entity.Member;
import com.tg.team.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(path = "/members/addition")
    public void addMembers(@RequestBody AddMemberRequest request){
         memberService.addMembers(request);
    }

    @GetMapping(path ="/members/get")
    public List<Member> getAllMembers(){
        return memberService.findMembers();
    }



}