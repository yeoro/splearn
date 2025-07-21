package yeoro.splearn.application.provided;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import yeoro.splearn.SplearnTestConfiguration;
import yeoro.splearn.domain.*;

import static org.assertj.core.api.Assertions.assertThat;
import static yeoro.splearn.domain.MemberFixture.createMemberRegisterRequest;

@SpringBootTest
@Import(SplearnTestConfiguration.class)
public class MemberRegisterTest {
    @Autowired
    private MemberRegister memberRegister;
    
    @Test
    void register() {
        Member member = memberRegister.register(createMemberRegisterRequest());

        assertThat(member.getId()).isNotNull();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }
}
