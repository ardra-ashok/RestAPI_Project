package resources;

import pojo.placesAPI.AddPlace;
import pojo.placesAPI.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(){
        AddPlace p = new AddPlace();
        p.setAccuracy(47);
        p.setName("Assam coffee shop");
        p.setPhone_number("(+91)983 893 393");
        p.setAddress("23 Liang St");
        p.setWebsite("https://assamshop.com");
        p.setLanguage("Hindi");
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
}
