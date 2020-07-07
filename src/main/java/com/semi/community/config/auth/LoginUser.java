package com.semi.community.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 세션 검사하는 코드 중복으로 인해
 * 어노테이션으로 처리
 */
@Target(ElementType.PARAMETER) //메소드의 파라미터로 선언된 객체에서만 사용 할 수 있다
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
