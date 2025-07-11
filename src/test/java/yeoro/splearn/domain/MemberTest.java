package yeoro.splearn.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberTest {
    @Test
    void createMember() {
        var member = new Member("yeoro@splearn.app", "yeoro", "secret");

        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }
}