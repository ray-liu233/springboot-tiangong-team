package com.tg.team.controller;

import com.tg.team.dto.AddStoryRequest;
import com.tg.team.entity.Story;
import com.tg.team.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {
    @Autowired
    private StoryService storyService;

    @PostMapping(path = "/story/addition/ba")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void baAddStores(){
        storyService.baAddStories();
    }

    @PostMapping(path = "/story/addition/normal")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addStories(@RequestBody AddStoryRequest addStoryRequest){
        storyService.addStories(addStoryRequest);
    }

    @GetMapping(path="/stories/get")
    public List<Story> getAllStories(){return storyService.findStories();}

    @PostMapping(path = "/stories/assigned/dev")
    public  String  devAssignedStories(){return storyService.assignedStories();}

    @PostMapping(path="/stories/done/dev")
    public  void  devDoneStories(){storyService.devDoneStories();}

    @DeleteMapping (path="/stories/delete/qa")
    public  void  qaDeleteStories(){storyService.qaDeleteStories();}

}
