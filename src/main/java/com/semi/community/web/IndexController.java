package com.semi.community.web;

import com.semi.community.config.auth.LoginUser;
import com.semi.community.config.auth.dto.SessionUser;
import com.semi.community.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.Session;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
//        logger.debug("=============================================Home");
//        logger.debug("=============================================user != null " + (user != null));
//
//        if(user != null) {
//            model.addAttribute("userName" , user.getName());
//        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "post-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(Model model, @PathVariable Long id) {
        model.addAttribute("post" , postsService.findById(id));
        return "posts-update";
    }
}
