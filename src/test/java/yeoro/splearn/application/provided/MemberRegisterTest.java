package yeoro.splearn.application.provided;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestConstructor;
import yeoro.splearn.SplearnTestConfiguration;
import yeoro.splearn.domain.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static yeoro.splearn.domain.MemberFixture.createMemberRegisterRequest;

@SpringBootTest
@Transactional
@Import(SplearnTestConfiguration.class)
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public record MemberRegisterTest(MemberRegister memberRegister) {
    
    @Test
    void register() {
        Member member = memberRegister.register(createMemberRegisterRequest());

        assertThat(member.getId()).isNotNull();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void duplicateEmailFail() {
        Member member = memberRegister.register(createMemberRegisterRequest());

        assertThatThrownBy(() -> memberRegister.register(createMemberRegisterRequest()))
                .isInstanceOf(DuplicateEmailException.class);
    }
}
