package com.bruxelas.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

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
import com.bruxelas.entities.Country;
import com.bruxelas.entities.Language;
import com.bruxelas.repositories.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BruxelasApplication.class})
@ActiveProfiles(profiles = "prod")
@WebAppConfiguration
public class CountryServiceTest {

	@InjectMocks
	private CountryService countryServiceMock;
	
	@Mock
	private CountryRepository countryRepositoryMock;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	public void testSave() throws Exception{
		Country countryTypeAny = new Country(null, "aaaaa", "aaa", Arrays.asList(new Language(null, "bbbbb")));

		when(this.countryRepositoryMock.save(countryTypeAny)).thenReturn(countryTypeAny);
		
		Country countryResponse = this.countryServiceMock.save(countryTypeAny);
		assertNotNull("[countryResponse] should not be null", countryResponse);
		assertEquals("[countryResponse] should be equals to [countryAny]", countryTypeAny, countryResponse);
		
		verify(this.countryRepositoryMock, times(1)).save(countryTypeAny);
	}
	
//	@Test
//	public void testFindAll(){
//		List<ConnectionType> countryMock = Arrays.asList(mock(ConnectionType.class));
//		
//		when(this.countryRepositoryMock.findAll()).thenReturn(countryMock);
//		
//		List<ConnectionType> countryReponse = (List<ConnectionType>) this.countryServiceMock.findAll();
//		assertNotNull("[countryReponse] should not be null", countryReponse);
//		assertEquals("[countryMock] should be equals to countryReponse", countryMock, countryReponse);
//		
//		verify(this.countryRepositoryMock, times(1)).findAll();
//	}
//	
//	@Test
//	public void testFindOne(){
//		ConnectionType countryMock = mock(ConnectionType.class);
//		
//		when(this.countryRepositoryMock.findOne(anyLong())).thenReturn(countryMock);
//		
//		ConnectionType countryReponse = this.countryServiceMock.findOne(anyLong());
//		assertNotNull("[countryReponse] should not be null", countryReponse);
//		assertEquals("[countryMock] should be equals to countryReponse", countryMock, countryReponse);
//		
//		verify(this.countryRepositoryMock, times(1)).findOne(anyLong());
//	}
//	
//	@Test
//	public void testDelete(){
//		doNothing().when(this.countryRepositoryMock).delete(anyLong());
//		this.countryServiceMock.delete(anyLong());
//		verify(this.countryRepositoryMock, times(1)).delete(anyLong());
//	}
}
