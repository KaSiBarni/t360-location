package location;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class LocationServiceIntegrationTest {

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private LocationService locationService;

    @Before
    public void clearList() {
        System.out.println("Clearing the database");
        locationDao.deleteAll();
    }

    @Test
    public void findAll(){
        locationDao.save("Budapest", 1.1,1.2);
        locationDao.save("Budapest", 1.12,1.24);
        locationDao.save("SZFVAR", 1.0,1.0);

        assertEquals(Arrays.asList("Budapest", "Budapest", "SZFVAR"), locationService.listLocations().stream()
                .map(Location::getName).collect(Collectors.toList()));

    }


}
