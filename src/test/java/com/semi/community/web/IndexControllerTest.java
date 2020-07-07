package com.semi.community.web;

import com.semi.community.domain.posts.Posts;
import com.semi.community.domain.posts.PostsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void mainLoading() {
        String body = this.restTemplate.getForObject("/" , String.class);
        assertThat(body).contains("등록");
    }

    @Test
    public void saveLoading() {
        String body = this.restTemplate.getForObject("/posts/save" , String.class);
        assertThat(body).contains("등록");
    }

    @Test
    public void updateLoading() {
        Posts savedPosts = postsRepository.save(Posts.builder().title("제목1").author("글쓴이1").content("내용1").build());
        Long id = savedPosts.getId();
        String body = this.restTemplate.getForObject("/posts/update/" + id , String.class);
        assertThat(body).contains(savedPosts.getTitle());
    }

}
