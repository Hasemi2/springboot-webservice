package com.semi.community.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveTest() {
        String title = "test";
        String content = "content";

        postsRepository.save(Posts.builder().title(title).content(content).author("semi").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void baseTimeEntityInsertTest() {
        LocalDateTime now = LocalDateTime.of(2020, 7, 7, 0, 0, 0);
        postsRepository.save(Posts.builder().title("제목").content("내용").author("세미").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>> " + posts.getCreatedDate() + ">>>>>>>" + posts.getUpdatedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getUpdatedDate()).isAfter(now);

    }
}
