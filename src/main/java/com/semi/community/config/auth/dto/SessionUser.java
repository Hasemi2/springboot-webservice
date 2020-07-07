package com.semi.community.config.auth.dto;

import com.semi.community.domain.user.User;
import lombok.Getter;

import java.io.Serializable;


/**
 * 인증된 사용자 정보만 필요
 * 엔티티는 변동 가능성이 높으므로 직렬화 하면 추후 변경점이 커지게 된다.
 */
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
