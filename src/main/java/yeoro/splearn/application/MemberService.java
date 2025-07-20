package yeoro.splearn.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yeoro.splearn.application.provided.MemberRegister;
import yeoro.splearn.application.required.EmailSender;
import yeoro.splearn.application.required.MemberRepository;
import yeoro.splearn.domain.Member;
import yeoro.splearn.domain.MemberRegisterRequest;
import yeoro.splearn.domain.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberRegister {
    private final MemberRepository memberRepository;
    private final EmailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberRegisterRequest registerRequest) {
        // check

        // domain model
        Member member = Member.register(registerRequest, passwordEncoder);

        // repository
        memberRepository.save(member);

        // post process
        emailSender.send(member.getEmail(), "등록을 완료해주세요", "아래 링크를 클릭해서 등록을 완료해주세요");

        return member;
    }
}
