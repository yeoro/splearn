package yeoro.splearn.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    void equality() {
        var email1 = new Email("yeoro@splearn.app");
        var email2 = new Email("yeoro@splearn.app");

        assertThat(email1).isEqualTo(email2);
    }
}