package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Member;
import com.example.demo.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
	MemberService memberService;
    @Autowired
	MemberRepository memberRepository;


	@Test
	public void memberJoin() throws Exception {
		// Given
		Member member = new Member();
		member.setName("hello");
		// When
		Long saveId = memberService.join(member);
		// Then
		Member findMember = memberRepository.findById(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}

	@Test
	public void duplicate_member_exception() throws Exception{
		// Given
		Member member1 = new Member();
		member1.setName("spring");
		Member member2 = new Member();
		member2.setName("spring");

		// When
		memberService.join(member1);
		IllegalStateException e = assertThrows(
				IllegalStateException.class,
				() -> memberService.join(member2)
				);// 예외가 발생해야 한다.
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}

}
