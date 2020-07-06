package com.semi.community.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Dao의 역할 DB Layer
 * Entity와 Entity Repository 는 함께 위치, 도메인 패키지에서 함께 관리
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
