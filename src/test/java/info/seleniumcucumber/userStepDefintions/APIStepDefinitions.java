package info.seleniumcucumber.userStepDefintions;

import cucumber.api.java.en.Given;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.Assert;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 * Created by donlam on 10/12/20.
 */
public class APIStepDefinitions {

    protected JSONObject response;

    @Given("^I call weather endpoint \"([^\"]*)\" with latitude of \"([^\"]*)\" and longitude of \"([^\"]*)\"$")
    public void navigate_to_specific_lat_long(String link,String lat, String long_) throws Throwable{
        //MAKE GET CAL https://api.weather.gov/gridpoints/TOP/${lat,long}/forecast/hourly"
        String url = link+lat+","+long_+"/forecast/hourly";
        response = sendGetRequest(url);
    }

    @Given("^I should get a status code of \"([^\"]*)\"$")
    public void compareStatusCode(String status_code) throws Throwable{
        Assert.assertEquals(status_code,response.get("status_code").toString());
    }

    //print out at least 12 hours of hourly forecast
    @Given("^I can print out hourly updates$")
    public void print_hourly_updates() throws Throwable{
        JSONArray periods = response.getJSONObject("properties").getJSONArray("periods");
        Assert.assertNotEquals(periods,null);
        for(int h=0; h<12; h++){
            System.out.println(periods.get(h));
        }
    }

   protected JSONObject sendGetRequest(String getEndpointURL) throws Exception {
        StringBuffer response = new StringBuffer();
        JSONObject responseObject = new JSONObject();
        try {
            URL url = new URL(getEndpointURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int responseCode = conn.getResponseCode();
            responseObject.put("status_code",responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inLine;
            while((inLine = in.readLine())!=null){
                response.append(inLine);
            }
            in.close();
            responseObject = new JSONObject(response.toString());
            responseObject.put("status_code",responseCode);
            return responseObject;
        } catch (Exception e) {
        }
        return responseObject;
    }




}
