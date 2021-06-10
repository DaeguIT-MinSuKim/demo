package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.demo.dto.Member;

class MemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	/**
	 * 각 테스트가 종료될 때 마다 실행
	 */
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}

	@Test
	void testSave() {
		Member member = new Member();
		member.setName("spring");
		// when
		repository.save(member);
		// then
		Member result = repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByName() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		// when
		Member result = repository.findByName("spring1").get();

		// then
		assertThat(result).isEqualTo(member1);
	}

	@Test
	void testFindAll() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		// when
		List<Member> result = repository.findAll();
		// then
		assertThat(result.size()).isEqualTo(2);
	}

}
