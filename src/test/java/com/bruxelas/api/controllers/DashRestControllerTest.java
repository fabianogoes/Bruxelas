package com.bruxelas.api.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BruxelasApplication.class})
@ActiveProfiles(profiles = "dev")
//@ComponentScan({"com.bruxelas", "com.bruxelas.api.controllers"})
@WebAppConfiguration
public class DashRestControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private DashRestController dashRestControllerMock;
	
	@Before
    public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(dashRestControllerMock).build();
    }   
    
	@Test
	public void testIndex() throws Exception{
        ResultActions resultActions = mockMvc.perform(get("/api/"))
        		.andExpect(status().isOk())
        		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        
        assertNotNull("resultActions should not be null", resultActions);
        
        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        String welcome = new ObjectMapper().readValue(response.getContentAsString(), String.class);
        
        assertThat(welcome).isEqualTo("Welcome Bruxelas Project");
	}
	
}
