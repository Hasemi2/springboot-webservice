package com.semi.community.domain.posts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Dao의 역할 DB Layer
 * Entity와 Entity Repository 는 함께 위치, 도메인 패키지에서 함께 관리
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // TODO: 2020-07-09  페이징 객체 pageable 사용 가능 하다는데?
    @Query(value = "SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc(Pageable pageable);

}
