import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.collect.Lists;
import com.pkma.spring.model.Player;
import com.pkma.spring.services.PlayerService;
import com.pkma.webapp.WebappMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebappMvcConfig.class})
@WebAppConfiguration
public class PlayerControllerTest {

    @Autowired
    protected WebApplicationContext wac;
    private MockMvc mockMvc;
    @Resource
    private PlayerService playerService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetAllPlayers() throws Exception {
        final List<Player> searchResults = Lists.newArrayList();
        searchResults.add(new Player());
        given(playerService.getAllPlayers()).willReturn(searchResults);

        mockMvc.perform(get("/spring_jdbc/find").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(playerService).getAllPlayers();
    }
}
