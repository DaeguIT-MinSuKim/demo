package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;

/**
 * 여기서는 향후 메모리 리포지토리를 다른 리포지토리로 변경할 예정이므로, 
 * 컴포넌트 스캔 방식 대신에 자바 코드로 스프링 빈을 설정하겠다.
 */
@Configuration
public class SpringConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

}
