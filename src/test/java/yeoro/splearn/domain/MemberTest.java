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
    
    @Test
    void activate() {
        var member = new Member("yeoro@splearn.app", "yeoro", "secret");

        member.activate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    void activateFail() {
        var member = new Member("yeoro@splearn.app", "yeoro", "secret");

        member.activate();

        assertThatThrownBy(() -> {
            member.activate();
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void deactivate() {
        var member = new Member("yeoro@splearn.app", "yeoro", "secret");
        member.activate();

        member.deactivate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
    }

    @Test
    void deactivateFail() {
        var member = new Member("yeoro@splearn.app", "yeoro", "secret");

        assertThatThrownBy(() -> member.deactivate()).isInstanceOf(IllegalStateException.class);

        member.activate();
        member.deactivate();

        assertThatThrownBy(() -> member.deactivate()).isInstanceOf(IllegalStateException.class);
    }
}