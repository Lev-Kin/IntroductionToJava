package u04сlasses.tasks.state;

import java.util.ArrayList;

public class District {
    private String districtName;
    private ArrayList<City> cities = new ArrayList<>();

    public District(String districtName) {
        this.districtName = districtName;
    }

    public District(String districtName, ArrayList<City> cities) {
        this.districtName = districtName;
        this.cities = cities;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public void setCities(City city) {
        cities.add(city);
    }
}
