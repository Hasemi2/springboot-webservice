package com.semi.community.web;

import com.semi.community.config.auth.LoginUser;
import com.semi.community.config.auth.dto.SessionUser;
import com.semi.community.service.PostsService;
import com.semi.community.web.dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user, @PageableDefault Pageable pageable) {
        List<PostsListResponseDto> posts = postsService.findAllDesc(pageable);
        model.addAttribute("posts",  posts);
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

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
