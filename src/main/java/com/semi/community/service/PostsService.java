package com.semi.community.service;

import com.semi.community.domain.posts.Posts;
import com.semi.community.domain.posts.PostsRepository;
import com.semi.community.web.dto.PostsListResponseDto;
import com.semi.community.web.dto.PostsResponseDto;
import com.semi.community.web.dto.PostsSaveRequestDto;
import com.semi.community.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RequiredArgsConstructor :: 초기화 되지 않은 final 필드, @NonNull 이 붙은 필드에 대해 생성자 생성
 * Autowired (x) -> 생성자를 통한 주입을 권장, 필드 인젝션 방지xx
 */
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;

    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postsRepository.delete(posts);
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional()
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto :: new)
                //.map(posts -> new PostsListResponseDto())
                .collect(Collectors.toList());
    }
}
