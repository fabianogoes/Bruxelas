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
import com.bruxelas.entities.Talker;
import com.bruxelas.services.TalkerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BruxelasApplication.class})
@ActiveProfiles(profiles = "dev")
@WebAppConfiguration
public class TalkerRestControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private TalkerRestController talkerRestControllerMock;
	
	@Mock
	private TalkerService talkerServiceMock;
	
	@Autowired 
	private ObjectMapper mapper;
	
	@Before
    public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(talkerRestControllerMock).build();
    }   
    
	@Test
	public void testSaveTalker() throws Exception{
		Talker talkerAny = new Talker(1L, "teste");
		String talkerAsJson = this.mapper.writeValueAsString(talkerAny);

		when(this.talkerServiceMock.save(talkerAny)).thenReturn(talkerAny);
		
		ResultActions resultActions = mockMvc.perform(post("/api/talker")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(talkerAsJson))
        		.andExpect(status().isOk())
        		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		assertNotNull("[resultActions] should not be null", resultActions);
		
		MockHttpServletResponse response = resultActions.andReturn().getResponse();
		assertNotNull("[ContentAsString] should not be null", response.getContentAsString());
		
		Talker talkerFromJson = this.mapper.readValue(response.getContentAsString(), Talker.class);
		assertEquals("[talkerFromJson] should be equals to [talkerAny]", talkerAny, talkerFromJson);
		
		verify(this.talkerServiceMock, times(1)).save(talkerAny);
	}
	
	@Test
	public void testFindAll() throws Exception{
		List<Talker> talkersMock = Arrays.asList(new Talker(1L, "teste"));
		
		when(this.talkerServiceMock.findAll()).thenReturn(talkersMock);
		
		ResultActions resultActions = mockMvc.perform(get("/api/talker"))
				.andExpect(status().isOk())
        		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		MockHttpServletResponse response = resultActions.andReturn().getResponse();
		List<Talker> talkersResponse = Arrays.asList(new ObjectMapper().readValue(response.getContentAsString(), Talker[].class));
		assertNotNull("[talkersResponse] should not be null", talkersResponse);
		assertEquals("[talkersMock] should be equals to [talkersResponse]", talkersMock, talkersResponse);
		
		verify(this.talkerServiceMock, times(1)).findAll();
	}
	
	@Test
	public void testFindOne() throws Exception{
		Talker talkerMock = new Talker(1L, "teste");
		
		when(this.talkerServiceMock.findOne(anyLong())).thenReturn(talkerMock);
		
		ResultActions resultActions = mockMvc.perform(get("/api/talker/"+anyLong()))
				.andExpect(status().isOk())
        		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		MockHttpServletResponse response = resultActions.andReturn().getResponse();
		Talker talkerResponse = new ObjectMapper().readValue(response.getContentAsString(), Talker.class);
		assertNotNull("[talkerResponse] should not be null", talkerResponse);
		assertEquals("[talkerMock] should be equals to [talkerResponse]", talkerMock, talkerResponse);
		
		verify(this.talkerServiceMock, times(1)).findOne(anyLong());
	}
	
	@Test
	public void testDelete() throws Exception{
		doNothing().when(this.talkerServiceMock).delete(anyLong());
		
		mockMvc.perform(get("/api/talker/delete/"+anyLong()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		verify(this.talkerServiceMock, times(1)).delete(anyLong());
	}
	
}
