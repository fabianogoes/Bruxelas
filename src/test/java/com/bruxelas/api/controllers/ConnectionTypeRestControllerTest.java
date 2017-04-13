package com.bruxelas.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bruxelas.BruxelasApplication;
import com.bruxelas.entities.ConnectionType;
import com.bruxelas.helpers.EntityAnyValueHelper;
import com.bruxelas.services.ConnectionTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BruxelasApplication.class})
@ActiveProfiles(profiles = "dev")
@WebAppConfiguration
public class ConnectionTypeRestControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private ConnectionTypeRestController connectionTypeRestControllerMock;
	
	@Mock
	private ConnectionTypeService connectionTypeServiceMock;
	
	@Autowired 
	private ObjectMapper mapper;
	
	@Before
    public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(connectionTypeRestControllerMock).build();
    }   
    
	@Test
	public void testSave() throws Exception{
		ConnectionType connectionTypeAny = EntityAnyValueHelper.anyConnectionType();
		String connectionTypeAsJson = this.mapper.writeValueAsString(connectionTypeAny);

		when(this.connectionTypeServiceMock.save(connectionTypeAny)).thenReturn(connectionTypeAny);
		
		ResultActions resultActions = mockMvc.perform(post("/api/connectiontype")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(connectionTypeAsJson))
        		.andExpect(status().isOk())
        		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		assertNotNull("[resultActions] should not be null", resultActions);
		
		MockHttpServletResponse response = resultActions.andReturn().getResponse();
		assertNotNull("[ContentAsString] should not be null", response.getContentAsString());
		
		ConnectionType connectionTypeFromJson = this.mapper.readValue(response.getContentAsString(), ConnectionType.class);
		System.out.println(response.getContentAsString());
		assertEquals("[connectionTypeFromJson] should be equals to [connectionTypeAny]", connectionTypeAny, connectionTypeFromJson);
		
		verify(this.connectionTypeServiceMock, times(1)).save(connectionTypeAny);
	}
	
	@Test
	public void testFindOne() throws Exception{
		ConnectionType connectionTypeMock = EntityAnyValueHelper.anyConnectionType();
		
		when(this.connectionTypeServiceMock.findOne(anyLong())).thenReturn(connectionTypeMock);
		
		ResultActions resultActions = mockMvc.perform(get("/api/connectiontype/"+anyLong()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		MockHttpServletResponse response = resultActions.andReturn().getResponse();
		ConnectionType connectionTypeResponse = new ObjectMapper().readValue(response.getContentAsString(), ConnectionType.class);
		assertNotNull("[connectionTypesResponse] should not be null", connectionTypeResponse);
		assertEquals("[connectionTypesMock] should be equals to [connectionTypesResponse]", connectionTypeMock, connectionTypeResponse);
		
		verify(this.connectionTypeServiceMock, times(1)).findOne(anyLong());
	}
	
	@Test
	public void testFindAll() throws Exception{
		List<ConnectionType> connectionTypesMock = Arrays.asList(EntityAnyValueHelper.anyConnectionType());
		
		when(this.connectionTypeServiceMock.findAll()).thenReturn(connectionTypesMock);
		
		ResultActions resultActions = mockMvc.perform(get("/api/connectiontype"))
				.andExpect(status().isOk())
        		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		MockHttpServletResponse response = resultActions.andReturn().getResponse();
		List<ConnectionType> connectionTypesResponse = Arrays.asList(new ObjectMapper().readValue(response.getContentAsString(), ConnectionType[].class));
		assertNotNull("[connectionTypesResponse] should not be null", connectionTypesResponse);
		assertEquals("[connectionTypesMock] should be equals to [connectionTypesResponse]", connectionTypesMock, connectionTypesResponse);
		
		verify(this.connectionTypeServiceMock, times(1)).findAll();
	}
	
	@Test
	public void testDelete() throws Exception{
		doNothing().when(this.connectionTypeServiceMock).delete(anyLong());
		
		mockMvc.perform(get("/api/connectiontype/delete/"+anyLong()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		verify(this.connectionTypeServiceMock, times(1)).delete(anyLong());
	}
}
