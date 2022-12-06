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

    @PostMapping(path = "/POST/stories/ba")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<Story> baAddStores(){
      return storyService.baAddStories();
    }

    @PostMapping(path = "/POST/stories/normal")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Story addStories(@RequestBody AddStoryRequest addStoryRequest){
        return storyService.addStories(addStoryRequest);
    }

    @GetMapping(path="/GET/stories")
    public List<Story> getAllStories(){return storyService.findStories();}

    @PostMapping(path = "/POST/stories/assignment/dev")
    public  List<Story>  devAssignedStories(){return storyService.assignedStories();}

    @PostMapping(path="/POST/stories/done/dev")
    public  List<Story>  devDoneStories(){return storyService.devDoneStories();}

    @DeleteMapping (path="/DELETE/stories/qa")
    public  List<Story>  qaDeleteStories(){return  storyService.deleteStories();}

}
