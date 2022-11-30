package location;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class LocationDao {

    private Long idCounter = 0L;
    private List<Location> locations = new ArrayList<>();

    public List<Location> findAll(){
        return locations;
    }

    public Location save(String name, double lat, double lon) {
        Location newLocation = new Location(idCounter,name,lat,lon);
        this.locations.add(newLocation);

        idCounter++;
        return newLocation;
    }

    public Optional<Location> findById(long id){
        return locations.stream().filter(l -> l.getId() == id).findAny();
    }

    public Optional<Location> update(long id, String name, double lat, double lon) {
        Optional<Location> location = locations.stream().filter(l -> l.getId() == id).findAny();
        if(location.isPresent()) {
            Location storedLocation = location.get();
            storedLocation.setName(name);
            storedLocation.setLat(lat);
            storedLocation.setLon(lon);
        }
        return location;
    }

    public Optional<Location> delete(long id) {
        Optional<Location> location = locations.stream().filter(l -> l.getId() == id).findAny();
        location.ifPresent(value -> locations.remove(value));
        return location;
    }

    public void deleteAll() {
        locations.clear();
    }
}
