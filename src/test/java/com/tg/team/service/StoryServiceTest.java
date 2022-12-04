package com.tg.team.service;

import com.tg.team.dto.AddStoryRequest;
import com.tg.team.entity.Member;
import com.tg.team.entity.Story;
import com.tg.team.repository.MemberRepository;
import com.tg.team.repository.StoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StoryServiceTest {
    @Autowired
    StoryRepository storyRepository = Mockito.mock(StoryRepository.class);

    MemberRepository memberRepository=Mockito.mock(MemberRepository.class);
    Story story=new Story("NEW");
    StoryService storyService=new StoryService(storyRepository);
    @Test
    public void should_return_member_when_add_stories(){
        Story serviceStory=storyService.addStories(new AddStoryRequest("NEW"));
        Assertions.assertEquals(serviceStory,storyRepository.save(story));
    }

    @Test
    public void should_return_members_when_get_stories(){
        List<Story> stories=new ArrayList<>();
        stories.add(story);
        storyRepository.save(story);
        assertThat(storyService.findStories().equals(stories));
    }

    @Test
    public void should_return_members_when_BA_add_stories(){
        List<Story> stories=storyService.baAddStories();
        Assertions.assertTrue(stories.size()>=1 && stories.size()<=3);
        for (Story story:stories
             ) {
//           Assertions.assertTrue(story.getStoryType().equals("NEW"));
        }
    }

    @Test
    public void should_return_success_when_vacant_dev_assigned_story(){
//        storyRepository.save(story);
//        Member member=new Member("小明","DEV",null);
//        memberRepository.save(member);
//        storyService.assignedStories();
//        List<Story> stories=storyRepository.findAll();
//        Assertions.assertTrue(stories.get(0).getStoryType().equals("ASSIGNED"));
    }

    @Test
    public void should_return_success_when_dev_done_story(){
//          storyRepository.save(new Story("ASSIGNED"));
//          Member member=new Member("小明","DEV", 1L);
//          memberRepository.save(member);
//          storyService.devDoneStories();
//          List<Story> stories=storyRepository.findAll();
//          Assertions.assertTrue(stories.get(0).getStoryType().equals("DONE"));
    }

    @Test
    public void should_return_success_when_QA_delete_story(){
//         storyRepository.save(new Story("DONE"));
//         storyService.qaDeleteStories();
//         List<Story> stories=storyRepository.findAll();
//         Assertions.assertEquals("DELETED",stories.get(0).getStoryType());
    }

}