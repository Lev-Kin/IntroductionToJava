package u04сlasses.tasks.state;

public class State {
    private String stateName;
    private String capital;
    private double area;
    private Region[] regions;
    private District[] districts;

    public State(String stateName, String capital, double area, Region[] regions, District[] districts) {
        this.stateName = stateName;
        this.capital = capital;
        this.area = area;
        this.regions = regions;
        this.districts = districts;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }

    public void printCapital() {
        System.out.println(capital);
    }

    public void printNumOfRegions() {
        System.out.println(regions.length);
    }

    public void printSquare() {
        System.out.println(area);
    }

    public void printRegionsNames() {
        for (int i = 0; i < regions.length; i++) {
            System.out.println(regions[i].getRegionName());
        }
    }
}
