package com.tg.team.service;

import com.tg.team.dto.AddMemberRequest;
import com.tg.team.entity.Member;
import com.tg.team.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void addMembers(AddMemberRequest request){
        memberRepository.save(new Member(request.getId(),request.getName(),request.getMemberType()));
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
}
