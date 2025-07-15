package yeoro.splearn.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class MemberTest {
    @Test
    void createMember() {
        var member = new Member("yeoro@splearn.app", "yeoro", "secret");

        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }
    
    @Test
    void constructorNullCheck() {
        assertThatThrownBy(() -> new Member(null, "yeoro", "secret"))
                .isInstanceOf(NullPointerException.class);
    }
}