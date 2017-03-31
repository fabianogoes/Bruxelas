package com.bruxelas.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.bruxelas.entities.Version;
import com.bruxelas.repositories.VersionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BruxelasApplication.class})
@ActiveProfiles(profiles = "dev")
@WebAppConfiguration
public class VersionServiceTest {

	@InjectMocks
	private VersionService versionServiceMock;
	
	@Mock
	private VersionRepository versionRepositoryMock;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	public void testFindActualVersion(){
		Version versionMock = mock(Version.class);
		
		when(this.versionRepositoryMock.findActualVersion()).thenReturn(versionMock);
		
		Version versionReponse = this.versionServiceMock.findActualVersion();
		assertNotNull("[versionReponse] should not be null", versionReponse);
		assertEquals("[versionMock] should be equals to versionReponse", versionMock, versionReponse);
		
		verify(this.versionRepositoryMock, times(1)).findActualVersion();
	}
}
