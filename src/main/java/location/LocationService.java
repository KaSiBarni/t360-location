package location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final LocationDao locationDao;

    public LocationService( LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public List<Location> listLocations(){
        return locationDao.findAll();
    }

    //kedvenc hely létrehozása
    public void createLocation(String name, double lat, double lon){
        locationDao.save(name,lat,lon);
    }

    //kedvenc hely keresése id alapján
    public Optional<Location> getLocationById(long id){
        Optional<Location> loc = locationDao.findById(id);
        return loc;
    }

    //kedvenc hely módosítása id alapján
    public Optional<Location> updateLocation(long id, String name, double lat, double lon){
        logger.debug("Item updated with new values: {}, {}, {}", name, lat, lon);
        return locationDao.update(id,name, lat, lon);
    }

    //kedvenc hely törlése
    public Optional<Location> deleteLocation(long id){
        return locationDao.delete(id);
    }

}
