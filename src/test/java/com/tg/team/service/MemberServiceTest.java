package com.tg.team.service;


import com.tg.team.dto.AddMemberRequest;
import com.tg.team.entity.Member;
import com.tg.team.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
class MemberServiceTest {
    @MockBean
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;
    Member member = new Member("小芳", "DEV");

    @Test
    public void should_return_member_when_add_members(){
        when(memberRepository.save(any(Member.class))).thenReturn(member);
        AddMemberRequest addMemberRequest=new AddMemberRequest(member.getName(),member.getMemberType());
        Member member1= memberService.addMembers(addMemberRequest);
        assertThat(member1.getName()).isEqualTo("小芳");
        assertThat(member1.getMemberType()).isEqualTo("DEV");
    }

    @Test
    public void should_return_member_when_get_members(){
        List<Member> members=new ArrayList<>();
        members.add(member);
        when(memberRepository.findAll()).thenReturn(members);
        assertThat(members.get(0).getName()).isEqualTo("小芳");
        assertThat(members.get(0).getMemberType()).isEqualTo("DEV");
    }

}