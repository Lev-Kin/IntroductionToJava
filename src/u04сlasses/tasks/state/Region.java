package u04сlasses.tasks.state;

import java.util.ArrayList;

public class Region {
    private String regionName;
    private ArrayList<District> districts = new ArrayList<>();

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Region(String regionName, ArrayList<District> districts) {
        this.regionName = regionName;
        this.districts = districts;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }

    public void setDistricts(District district) {
        districts.add(district);
    }
}
