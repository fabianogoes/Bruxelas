package com.bruxelas.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bruxelas.BruxelasApplication;
import com.bruxelas.entities.CategoryConnectionType;
import com.bruxelas.entities.ConnectionType;
import com.bruxelas.repositories.ConnectionTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BruxelasApplication.class})
@ActiveProfiles(profiles = "dev")
@WebAppConfiguration
public class ConnectionTypeServiceTest {

	@InjectMocks
	private ConnectionTypeService connectionTypeServiceMock;
	
	@Mock
	private ConnectionTypeRepository connectionTypeRepositoryMock;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	public void testSave() throws Exception{
		ConnectionType connectionTypeAny = new ConnectionType(null, anyString(), CategoryConnectionType.ENGLISH);

		when(this.connectionTypeRepositoryMock.save(connectionTypeAny)).thenReturn(connectionTypeAny);
		
		ConnectionType connectionTypeResponse = this.connectionTypeServiceMock.save(connectionTypeAny);
		assertNotNull("[connectionTypeResponse] should not be null", connectionTypeResponse);
		assertEquals("[connectionTypeResponse] should be equals to [connectionTypeAny]", connectionTypeAny, connectionTypeResponse);
		
		verify(this.connectionTypeRepositoryMock, times(1)).save(connectionTypeAny);
	}
	
	@Test
	public void testFindAll(){
		List<ConnectionType> connectionTypeMock = Arrays.asList(mock(ConnectionType.class));
		
		when(this.connectionTypeRepositoryMock.findAll()).thenReturn(connectionTypeMock);
		
		List<ConnectionType> connectionTypeReponse = (List<ConnectionType>) this.connectionTypeServiceMock.findAll();
		assertNotNull("[connectionTypeReponse] should not be null", connectionTypeReponse);
		assertEquals("[connectionTypeMock] should be equals to connectionTypeReponse", connectionTypeMock, connectionTypeReponse);
		
		verify(this.connectionTypeRepositoryMock, times(1)).findAll();
	}
	
	@Test
	public void testFindOne(){
		ConnectionType connectionTypeMock = mock(ConnectionType.class);
		
		when(this.connectionTypeRepositoryMock.findOne(anyLong())).thenReturn(connectionTypeMock);
		
		ConnectionType connectionTypeReponse = this.connectionTypeServiceMock.findOne(anyLong());
		assertNotNull("[connectionTypeReponse] should not be null", connectionTypeReponse);
		assertEquals("[connectionTypeMock] should be equals to connectionTypeReponse", connectionTypeMock, connectionTypeReponse);
		
		verify(this.connectionTypeRepositoryMock, times(1)).findOne(anyLong());
	}
	
	@Test
	public void testDelete(){
		doNothing().when(this.connectionTypeRepositoryMock).delete(anyLong());
		this.connectionTypeServiceMock.delete(anyLong());
		verify(this.connectionTypeRepositoryMock, times(1)).delete(anyLong());
	}
}
