package com.tg.team.service;


import com.tg.team.dto.AddMemberRequest;
import com.tg.team.entity.Member;
import com.tg.team.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberServiceTest {

    MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
    Member member = new Member("小芳", "DEV", null);
    MemberService memberService = new MemberService(memberRepository);

    @Test
    public void should_return_member_when_add_members(){
        Member member = new Member("小芳", "DEV", null);
        Member serviceMember = memberService.addMembers(new AddMemberRequest("小芳", "DEV", null));
        Assertions.assertEquals(serviceMember, memberRepository.save(member));
    }

    @Test
    public void should_return_member_when_get_members(){
        List<Member> members=new ArrayList<>();
        members.add(member);
        memberRepository.save(member);
        assertThat(memberService.findMembers().equals(members));
    }

}