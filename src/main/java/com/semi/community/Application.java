package com.semi.community;

import com.semi.community.domain.posts.Posts;
import com.semi.community.domain.posts.PostsRepository;
import com.semi.community.domain.user.Role;
import com.semi.community.domain.user.User;
import com.semi.community.domain.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.stream.IntStream;

//@EnableJpaAuditing //Jpa Auditing 활성화
@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner runner(UserRepository userRepository, PostsRepository postsRepository) throws Exception{
//        return (args -> {
//            User user = userRepository.save(
//                    User.builder()
//                    .name("semi")
//                    .email("semi@semi.com")
//                    .role(Role.USER)
//                    .build());
//
//            IntStream.rangeClosed(1, 200).forEach(index ->
//                    postsRepository.save(Posts.builder()
//                    .author(user.getName() + index)
//                    .title("제목" + index)
//                    .content("내용" + index).build())
//                    );
//        });
//    }

    /**
     * sentry 설정
     * @return
     */
    @Bean
    public HandlerExceptionResolver sentryExceptionResolver() {
        return new io.sentry.spring.SentryExceptionResolver();
    }

    @Bean
    public ServletContextInitializer sentryServletContextInitializer() {
        return new io.sentry.spring.SentryServletContextInitializer();
    }
}