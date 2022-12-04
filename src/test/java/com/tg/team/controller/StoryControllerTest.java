package com.tg.team.controller;

import com.tg.team.service.StoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.verify;

@WebMvcTest(StoryController.class)
class StoryControllerTest {
    public static final String STORY_REQUEST = "{\n" +
            "\"storyType\":\"NEW\"\n" +
            "}";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoryService storyService;

    @Test
    void should_return_Ok_when_get_stories() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/GET/stories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
                verify(storyService).findStories();
    }

    @Test
    void should_return_Created_when_add_stories() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/stories/normal")
                        .content(STORY_REQUEST)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void should_return_Created_when_BA_add_stories() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/stories/ba")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void should_return_Ok_when_BA_assigned_stories() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/stories/assignment/dev")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void should_return_Ok_when_DEV_done_stories() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/POST/stories/done/dev")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void should_return_Ok_when_QA_delete_Done_stories() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/DELETE/stories/qa")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}