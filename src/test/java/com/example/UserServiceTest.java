package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class UserServiceTest {
    private final UserService userService = new UserService();

    @Test
    void testFindUser_Success() throws Exception {
        try (MockedStatic<DriverManager> mockedDriverManager = mockStatic(DriverManager.class)) {
            Connection mockConn = mock(Connection.class);
            PreparedStatement mockPstmt = mock(PreparedStatement.class);
            ResultSet mockRs = mock(ResultSet.class);

            mockedDriverManager.when(() -> DriverManager.getConnection(anyString(), anyString(), anyString()))
                               .thenReturn(mockConn);
            when(mockConn.prepareStatement(anyString())).thenReturn(mockPstmt);
            when(mockPstmt.executeQuery()).thenReturn(mockRs);
            when(mockRs.next()).thenReturn(true);
            when(mockRs.getString("name")).thenReturn("admin");

            assertDoesNotThrow(() -> userService.findUser("admin"));
        }
    }

    @Test
    void testDeleteUser_Success() throws Exception {
        try (MockedStatic<DriverManager> mockedDriverManager = mockStatic(DriverManager.class)) {
            Connection mockConn = mock(Connection.class);
            PreparedStatement mockPstmt = mock(PreparedStatement.class);

            mockedDriverManager.when(() -> DriverManager.getConnection(anyString(), anyString(), anyString()))
                               .thenReturn(mockConn);
            when(mockConn.prepareStatement(anyString())).thenReturn(mockPstmt);

            assertDoesNotThrow(() -> userService.deleteUser("admin"));
        }
    }
}