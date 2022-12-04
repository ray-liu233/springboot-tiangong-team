package com.tg.team.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tg.team.dto.AddMemberRequest;
import com.tg.team.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(MemberController.class)
class MemberControllerTest {
    //given
    public static final String MEMBER_REQUEST = "{\n" +
            "\"name\":\"小芳\",\n" +
            "\"memberType\":\"QA\",\n" +
            "\"storyId\":\"null\"\n" +
            "}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    void should_return_Created_when_add_members() throws Exception {
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/members")
                        .content(MEMBER_REQUEST)
                        .contentType(MediaType.APPLICATION_JSON))
        //then
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void should_return_Ok_when_get_members() throws Exception{
        AddMemberRequest addMemberRequest=new ObjectMapper().readValue(MEMBER_REQUEST,AddMemberRequest.class);
        memberService.addMembers(addMemberRequest);
        mockMvc.perform(MockMvcRequestBuilders.get("/GET/members")
                        .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id",Matchers.is(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is("小芳")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.memberType",Matchers.is("QA")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.storyId",Matchers.is("null")));
    }
}