package resources;

import pojo.placesAPI.AddPlace;
import pojo.placesAPI.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(String name, String language, String address){
        AddPlace p = new AddPlace();
        p.setAccuracy(47);
        p.setName(name);
        p.setPhone_number("(+91)983 893 393");
        p.setAddress(address);
        p.setWebsite("https://assamshop.com");
        p.setLanguage(language);
        List<String> myList = new ArrayList<>();
        myList.add("Shoe park");
        myList.add("Shop land");
        p.setTypes(myList);
        Location l = new Location();
        l.setLat(45.87466);
        l.setLng(-67.87466);
        p.setLocation(l);
        return p;
    }

    public String DeletePlacePayload(String place_id){
//        DeletePlace delPlace = new DeletePlace();
//        delPlace.setPlace_id(place_id);
//        return delPlace;
        return "{\n    \"place_id\": \""+place_id+"\"\n}";


    }
}
