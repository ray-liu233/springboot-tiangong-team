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

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }

    public Member addMembers(AddMemberRequest request){
      return  memberRepository.save(new Member(request.getName(),request.getMemberType(), request.getStoryId()));
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

}





