package yeoro.splearn.application.required;

import org.springframework.data.repository.Repository;
import yeoro.splearn.domain.Email;
import yeoro.splearn.domain.Member;

import java.util.Optional;

/**
 * 회원 정보를 저장하거나 조회한다
 */
public interface MemberRepository extends Repository<Member, Long> {
    Member save(Member member);

    Optional<Member> findByEmail(Email email);
}
