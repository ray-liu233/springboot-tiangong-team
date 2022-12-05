package com.tg.team.controller;

import com.tg.team.dto.AddStoryRequest;
import com.tg.team.entity.Story;
import com.tg.team.service.StoryService;
import org.hamcrest.Matchers;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@WebMvcTest(StoryController.class)
class StoryControllerTest {
    public static final String STORY_REQUEST = "{\n" +
            "\"storyType\":\"NEW\"\n" +
            "}";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoryService storyService;

    Story story=new Story("NEW");
    @Test
    void should_return_Ok_when_get_stories() throws Exception{
        List<Story> stories=new ArrayList<>();
        stories.add(story);
        when(storyService.findStories()).thenReturn(stories);
        mockMvc.perform(MockMvcRequestBuilders.get("/GET/stories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].storyType", Matchers.is("NEW")));
    }

    @Test
    void should_return_Created_when_add_stories() throws Exception{
        when(storyService.addStories(any(AddStoryRequest.class))).thenReturn(story);
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/stories/normal")
                        .content(STORY_REQUEST)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.storyType",Matchers.is("NEW")));
    }

    @Test
    void should_return_Created_when_BA_add_stories() throws Exception{
        List<Story> stories=new ArrayList<>();
        stories.add(story);
        stories.add(story);
        when(storyService.baAddStories()).thenReturn(stories);
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/stories/ba")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].storyType",Matchers.is("NEW")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].storyType",Matchers.is("NEW")));
    }

    @Test
    void should_return_Ok_when_BA_assigned_stories() throws Exception{
        List<Story> stories=new ArrayList<>();
        stories.add(new Story("ASSIGNED"));
        when(storyService.assignedStories()).thenReturn(stories);
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/stories/assignment/dev")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].storyType",Matchers.is("ASSIGNED")));

    }

    @Test
    void should_return_Ok_when_DEV_done_stories() throws Exception{
        Story story1=new Story("DONE");
        List<Story> stories=new ArrayList<>();
        stories.add(story1);
        when(storyService.devDoneStories()).thenReturn(stories);
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/stories/done/dev")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].storyType",Matchers.is("DONE")));
    }

    @Test
    void should_return_Ok_when_QA_delete_Done_stories() throws Exception{
        Story story1=new Story("DELETED");
        List<Story> stories=new ArrayList<>();
        stories.add(story1);
        when(storyService.qaDeleteStories()).thenReturn(stories);
        mockMvc.perform(MockMvcRequestBuilders.delete("/DELETE/stories/qa")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].storyType",Matchers.is("DELETED")));
    }

}