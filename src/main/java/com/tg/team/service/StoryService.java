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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class StoryService {
    Random random=new Random();

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Story> baAddStories() {
        List<Story> stories=new ArrayList<>();
        int count = random.nextInt(3) + 1;
        for (int i = 0; i < count; i++) {
           stories.add(new Story("new"));
        }
        return storyRepository.saveAll(stories);
    }

    public Story addStories(AddStoryRequest addStoryRequest) {
       return storyRepository.save(new Story(addStoryRequest.getStoryType()));
    }

    public List<Story> findStories(){return storyRepository.findAll();}


    public  List<Story>  assignedStories() {
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
            return  storyRepository.saveAll(filteredStories);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is no vacant DEV");
    }
    public List<Story> devDoneStories() {
        List<Member> filteredMember=memberRepository.findAll().stream()
                                    .filter(member -> member.getMemberType().equals("DEV"))
                                    .filter(member -> String.valueOf(member.getStoryId())!=null)
                                    .collect(Collectors.toList());

//        for (int i = 0; i < filteredMember.size() ; i++) {
//            Long id=filteredMember.get(i).getStoryId();
//            Optional<Story> story=storyRepository.findById(id);
//            story.get().setStoryType("DONE");
//            filteredMember.get(i).setStoryId(null);
//        }

        List<Story> filteredStories = storyRepository.findAll().stream()
                .filter(story -> story.getStoryType().equals("ASSIGNED"))
                .collect(Collectors.toList());
        for (int i = 0; i <filteredStories.size() ; i++) {
            filteredMember.get(i).setStoryId(null);
            filteredStories.get(i).setStoryType("DONE");
        }
        memberRepository.saveAll(filteredMember);
        return storyRepository.saveAll(filteredStories);
     }

    public List<Story> qaDeleteStories() {
        List<Story> filteredStories=storyRepository.findAll().stream()
                .filter(story ->story.getStoryType().equals("DONE"))
                .collect(Collectors.toList());
        int minSize=Math.min(2,filteredStories.size());
        for (int i = 0; i < minSize ; i++) {
            filteredStories.get(i).setStoryType("DELETED");
        }
        return  storyRepository.saveAll(filteredStories);
    }
}


