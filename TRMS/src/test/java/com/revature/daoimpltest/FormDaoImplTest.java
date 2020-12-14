package com.revature.daoimpltest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.daoimpl.FormDaoImpl;
import com.revature.service.FormService;

public class FormDaoImplTest {

	@Mock private FormDaoImpl mockFDI;
	@Mock private FormService mockFSERV;
	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	
	@Test
	public void testGetFormById() {
		MockitoAnnotations.initMocks(this);
			assertEquals("eventId", 35);
			Mockito.verify(mockFDI);
	
		
	}
}
