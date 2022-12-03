package com.tg.team.service;

import com.tg.team.dto.AddStoryRequest;
import com.tg.team.entity.Member;
import com.tg.team.entity.Story;
import com.tg.team.repository.MemberRepository;
import com.tg.team.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class StoryService {
    Random random=new Random();

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private MemberRepository memberRepository;

    public void baAddStories() {
        int count = random.nextInt(3) + 1;
        for (int i = 0; i < count; i++) {
            storyRepository.save(new Story("NEW"));
        }
    }

    public void addStories(AddStoryRequest addStoryRequest) {
        storyRepository.save(new Story(addStoryRequest.getStoryType()));
    }

    public List<Story> findStories(){return storyRepository.findAll();}


    public  String  assignedStories() {
        List<Member> filteredMember = memberRepository.findAll().stream()
                .filter(member -> member.getMemberType().equals("DEV"))
                .filter(member -> String.valueOf(member.getStoryId()).equals("null"))
                .collect(Collectors.toList());
        if (filteredMember.size() > 0) {

            List<Story> filteredStories = storyRepository.findAll().stream()
                    .filter(story -> story.getStoryType().equals("NEW"))
                    .collect(Collectors.toList());

            int finalSize = Math.min(filteredMember.size(),filteredStories.size());

            for (int i = 0; i < finalSize; i++) {
                filteredMember.get(i).setStoryId(filteredStories.get(i).getId());
                filteredStories.get(i).setStoryType("ASSIGNED");
            }
            memberRepository.saveAll(filteredMember);
            storyRepository.saveAll(filteredStories);
            return "ALL VACANT DEVS ARE ASSIGNED ";
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is no vacant DEV");
    }
    public void devDoneStories() {
        List<Member> filteredMember=memberRepository.findAll().stream()
                                    .filter(member -> member.getMemberType().equals("DEV"))
                                    .filter(member -> String.valueOf(member.getStoryId())!=null)
                                    .collect(Collectors.toList());

        List<Story> filteredStories=storyRepository.findAll().stream()
                .filter(story ->story.getStoryType().equals("ASSIGNED"))
                .collect(Collectors.toList());

        for (int i = 0; i <filteredStories.size() ; i++) {
            filteredMember.get(i).setStoryId(null);
            filteredStories.get(i).setStoryType("DONE");
        }
        memberRepository.saveAll(filteredMember);
        storyRepository.saveAll(filteredStories);
     }

    public void qaDeleteStories() {
        List<Story> filteredStories=storyRepository.findAll().stream()
                .filter(story ->story.getStoryType().equals("DONE"))
                .collect(Collectors.toList());

        for (Story story:filteredStories
             ) {
            story.setStoryType("DELETED");
        }
        storyRepository.saveAll(filteredStories);
    }
}


