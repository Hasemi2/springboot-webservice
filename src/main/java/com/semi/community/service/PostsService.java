package com.semi.community.service;

import com.semi.community.domain.posts.PostsRepository;
import com.semi.community.web.dto.PostsSaveRequestDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
