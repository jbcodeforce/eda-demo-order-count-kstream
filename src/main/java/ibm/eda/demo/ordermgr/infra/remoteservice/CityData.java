package ibm.eda.demo.ordermgr.infra.remoteservice;

public class CityData {
 
    String zip_code;
    Long lat;
    Long lng;
    String city;
    String state;
    TimeZone timezone;

    String[] acceptable_city_names;
    Integer[] area_codes;

    public CityData(){
    }

    public String toString(){
        return zip_code + " = " + city + " state:" + state;
    }
}
