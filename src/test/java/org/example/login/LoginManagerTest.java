package org.example.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginManagerTest {

    private HashMap<String, String> userRepo;
    private LoginManager loginManager;

    private final String TEST_USER = "testUser";
    private final String TEST_PASSWORD = "testPassword";

    @BeforeEach
    void setUp() {
        this.userRepo = new HashMap<String, String>();
        this.userRepo.put(TEST_USER, TEST_PASSWORD);
        this.loginManager = new LoginManager(userRepo);
    }

    @Test
    void testLoginMethod_returnsSession_whenUserLogsInWithData() {
        // Build

        // Act
        Session res = loginManager.login(TEST_USER, TEST_PASSWORD);

        // Assert
        assertThat(res.getUsername()).isEqualTo(TEST_USER);
        assertThat(res.getSessionId()).isNotNull();

    }

    @Test
    void testLoginMethod_throwsUserNotFoundException_whenUserNotPresent() {
        String UNREGISTERED_USER = "unregisteredUser";

        var e = assertThrows(UserNotFoundException.class,
                () -> loginManager.login(UNREGISTERED_USER, TEST_PASSWORD)
        );
        assertEquals("User with username unregisteredUser not found", e.getMessage());

    }

    @Test
    void testLoginMethod_throwsInvalidCredentialsException_whenPasswordIsWrong() {
        assertThrows(InvalidCredentialsException.class,
                () -> loginManager.login(TEST_USER, "incorrectPassword")
        );
    }


}