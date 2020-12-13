package com.revature.dbtest;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.util.ConnFactory;

import junit.framework.Assert;

public class ConnFactoryTest {
	@Mock private ConnFactory connFac;
	@Mock private Connection mockConn;
	@Mock private Statement mockStmt;
	@Mock private PreparedStatement mockPstmt;
	@Mock private ResultSet mockRS;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	//Test Passed
	@Test
	public void testMockConnection() throws Exception{
		Mockito.when(mockConn.createStatement()).thenReturn(mockStmt);
		Mockito.when(mockConn.prepareStatement("")).thenReturn(mockPstmt);
		Mockito.verify(mockConn.createStatement(), Mockito.times(1));
	}
}
