package com.tg.team.controller;

import com.tg.team.dto.AddMemberRequest;
import com.tg.team.entity.Member;
import com.tg.team.service.MemberService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@WebMvcTest(MemberController.class)
class MemberControllerTest {
    //given
    public static final String MEMBER_REQUEST = "{\n" +
            "\"name\":\"小芳\",\n" +
            "\"memberType\":\"QA\"\n" +
            "}" ;
    private Member member;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        member=new Member("小芳","QA");
    }
    @Test
    void should_return_Created_when_add_members() throws Exception {
        //given
        when(memberService.addMembers(any(AddMemberRequest.class))).thenReturn(member);

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/members")
                        .content(MEMBER_REQUEST)
                        .contentType(MediaType.APPLICATION_JSON))
        //then
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("小芳")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.memberType", Matchers.is("QA")));
    }

    @Test
    void should_return_Ok_when_get_members() throws Exception{
          //given
          List<Member> members=new ArrayList<>();
          members.add(member);
          when(memberService.findMembers()).thenReturn(members);

          mockMvc.perform(MockMvcRequestBuilders.get("/GET/members")
                        .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",Matchers.is("小芳")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].memberType",Matchers.is("QA")));
    }
}