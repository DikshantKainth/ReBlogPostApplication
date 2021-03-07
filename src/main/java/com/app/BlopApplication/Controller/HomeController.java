package com.app.BlopApplication.Controller;


import com.app.BlopApplication.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPosts(Model model){

        //Business Logic

        ArrayList<Post> posts=new ArrayList<>();

        Post post1=new Post();
        post1.setTitle("Smartphones");
        post1.setBody("Android is better then iPhone");
        post1.setDate(new Date());

        Post post2=new Post();
        post2.setTitle("Beauty");
        post2.setBody("He has opened a new beauty parlour!");
        post2.setDate(new Date());

        Post post3=new Post();
        post3.setTitle("Tesla");
        post3.setBody("CEO of tesla is encouraging SpaceX");
        post3.setDate(new Date());

        Post post4=new Post();
        post4.setTitle("NASA");
        post4.setBody("SpaceX has taken over NASA");
        post4.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

        model.addAttribute("posts",posts);

        return "index";
    }
}
