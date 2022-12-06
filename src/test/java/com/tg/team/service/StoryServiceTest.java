package com.tg.team.service;

import com.tg.team.dto.AddStoryRequest;
import com.tg.team.entity.Member;
import com.tg.team.entity.Story;
import com.tg.team.repository.MemberRepository;
import com.tg.team.repository.StoryRepository;
import org.junit.jupiter.api.Assertions;
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
class StoryServiceTest {
    @MockBean
    private StoryRepository storyRepository;
    @MockBean
    private MemberRepository memberRepository;
    @Autowired
    private  StoryService storyService;
    Story story=new Story("NEW");
    @Test
    public void should_return_story_when_add_stories(){
        when(storyRepository.save(any(Story.class))).thenReturn(story);
        Story story1=storyService.addStories(new AddStoryRequest(story.getStoryType()));
        assertThat(story1.getStoryType()).isEqualTo("NEW");
    }

    @Test
    public void should_return_stories_when_get_stories(){
        List<Story> stories=new ArrayList<>();
        stories.add(story);
        when(storyRepository.findAll()).thenReturn(stories);
        assertThat(storyService.findStories().get(0).getStoryType()).isEqualTo("NEW");
    }

    @Test
    public void should_return_stories_when_BA_add_stories(){
        List<Story> stories=new ArrayList<>();
        stories.add(new Story("NEW"));
        when(storyRepository.saveAll(any())).thenReturn(stories);
        List<Story> stories1=storyService.baAddStories();
        Assertions.assertTrue(stories1.size()>=1 && stories.size()<=3);
        Assertions.assertEquals("NEW",stories1.get(0).getStoryType());

    }

    @Test
    public void should_return_success_when_vacant_dev_assigned_story(){
        Member member=new Member("小明","DEV");
        List<Story> stories=new ArrayList<>();
        stories.add(story);
        List<Member> members=new ArrayList<>();
        members.add(member);

        when(memberRepository.findAll()).thenReturn(members);
        when(storyRepository.findAll()).thenReturn(stories);
        when(memberRepository.saveAll(any())).thenReturn(members);
        when(storyRepository.saveAll(any())).thenReturn(stories);

        List<Story> stories1=storyService.assignedStories();
        Assertions.assertEquals("ASSIGNED",stories1.get(0).getStoryType());
    }

    @Test
    public void should_return_success_when_dev_done_story(){
          Story story1=new Story("ASSIGNED");
          Member member=new Member("小明","DEV", 1L);

          List<Story> stories=new ArrayList<>();
          stories.add(story1);

          List<Member> members=new ArrayList<>();
          members.add(member);
          when(storyRepository.saveAll(any())).thenReturn(stories);
          when(memberRepository.saveAll(any())).thenReturn(members);
          when(storyRepository.findAll()).thenReturn(stories);
          when(memberRepository.findAll()).thenReturn(members);

          List<Story> stories1=storyService.devDoneStories();

        Assertions.assertEquals("DONE", stories1.get(0).getStoryType());
    }

    @Test
    public void should_return_success_when_QA_delete_story(){
         Story story1=new Story("DONE");
         Story story2=new Story("DONE");
         List<Story> stories=new ArrayList<>();
         stories.add(story1);
         stories.add(story2);

         when(storyRepository.saveAll(any())).thenReturn(stories);
         when(storyRepository.findAll()).thenReturn(stories);

         List<Story> stories1=storyService.deleteStories();

         Assertions.assertEquals("DELETED",stories1.get(0).getStoryType());
         Assertions.assertEquals("DELETED",stories1.get(1).getStoryType());
    }

}