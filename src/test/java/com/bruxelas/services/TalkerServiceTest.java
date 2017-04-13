package com.bruxelas.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import com.bruxelas.builders.CountryBuilder;
import com.bruxelas.builders.LanguageBuilder;
import com.bruxelas.builders.TalkerBuilder;
import com.bruxelas.entities.Country;
import com.bruxelas.entities.Language;
import com.bruxelas.entities.Talker;
import com.bruxelas.helpers.RandomValueGeneratorHelper;
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
	
	private Language languageAny;
	
	private Country countryAny;
	
	private Talker talkerAny;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		
		this.languageAny = new LanguageBuilder()
				.withId(null)
				.withName(RandomValueGeneratorHelper.anyString(10))
				.build();
		
		this.countryAny = new CountryBuilder()
				.withId(null)
				.withName(RandomValueGeneratorHelper.anyString())
				.withNativeName(RandomValueGeneratorHelper.anyString(10))
				.withLanguages(Arrays.asList(this.languageAny))
				.build();
		
		this.talkerAny = new TalkerBuilder()
				.withId(null)
				.withName(RandomValueGeneratorHelper.anyString())
				.withBornIn(this.countryAny)
				.withLivingIn(this.countryAny)
				.withNativeLanguage(this.languageAny)
				.build();
	}	
	
	@Test
	public void testSave() throws Exception{
		when(this.talkerRepositoryMock.save(this.talkerAny)).thenReturn(this.talkerAny);
		
		Talker talkerResponse = this.talkerServiceMock.save(this.talkerAny);
		assertNotNull("[talkerResponse] should not be null", talkerResponse);
		assertEquals("[talkerResponse] should be equals to [talkerAny]", this.talkerAny, talkerResponse);
		
		verify(this.talkerRepositoryMock, times(1)).save(this.talkerAny);
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
