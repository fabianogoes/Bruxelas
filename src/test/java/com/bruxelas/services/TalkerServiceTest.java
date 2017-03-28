package com.bruxelas.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
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
import com.bruxelas.entities.Talker;
import com.bruxelas.repositories.TalkerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BruxelasApplication.class})
@ActiveProfiles(profiles = "dev")
@WebAppConfiguration
public class TalkerServiceTest {

	@InjectMocks
	private TalkerService talkerServiceMock;
	
	@Mock
	private TalkerRepository talkerRepositoryMock;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	public void testSave() throws Exception{
		Talker talkerAny = new Talker(null, anyString());

		when(this.talkerRepositoryMock.save(talkerAny)).thenReturn(talkerAny);
		
		Talker talkerResponse = this.talkerServiceMock.save(talkerAny);
		assertNotNull("[talkerResponse] should not be null", talkerResponse);
		assertEquals("[talkerResponse] should be equals to [talkerAny]", talkerAny, talkerResponse);
		
		verify(this.talkerRepositoryMock, times(1)).save(talkerAny);
	}
	
	@Test
	public void testFindAll(){
		List<Talker> talkersMock = Arrays.asList(mock(Talker.class));
		
		when(this.talkerRepositoryMock.findAll()).thenReturn(talkersMock);
		
		List<Talker> talkersReponse = (List<Talker>) this.talkerServiceMock.findAll();
		assertNotNull("[talkersReponse] should not be null", talkersReponse);
		assertEquals("[talkersMock] should be equals to talkersReponse", talkersMock, talkersReponse);
		
		verify(this.talkerRepositoryMock, times(1)).findAll();
	}
}
