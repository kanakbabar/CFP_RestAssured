package com.bridgelabz;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class twitter
{ // 1568081273121574912
    @Test
    public void tweetTest(){
        Response response = RestAssured.given().auth()
                .oauth("42KxOgzZw9XUZuHG70eF1ZNBL","G1woAa4cDnwzVq7yY0L4gOBOiTdQlCGiDV2bISAKZ5aGxdiHwH","4003503614-3PvhKAkJ3j6lS6mktFXtrevpvIiDQkl0fnzsmKS","aM8wi0nWg6fLuWfOv73i85WDR4OXgp40sylbvpxvp8QKb")
                .delete("https://api.twitter.com/2/tweets/1568089256211660801");
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Body: "+response.asPrettyString());
    }


   //  1568088784927096833
    //  1568089256211660801
    @Test
    public void posttweetTest(){
        Response response = RestAssured.given().auth()
                .oauth("42KxOgzZw9XUZuHG70eF1ZNBL","G1woAa4cDnwzVq7yY0L4gOBOiTdQlCGiDV2bISAKZ5aGxdiHwH","4003503614-3PvhKAkJ3j6lS6mktFXtrevpvIiDQkl0fnzsmKS","aM8wi0nWg6fLuWfOv73i85WDR4OXgp40sylbvpxvp8QKb")
                .post("https://api.twitter.com/1.1/statuses/update.json?status=Hi Folks this is my first tweet using rest assured");
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Body: "+response.asPrettyString());
    }

    @Test
    public void posttweetTest1(){
        Response response = RestAssured.given().auth()
                .oauth("42KxOgzZw9XUZuHG70eF1ZNBL","G1woAa4cDnwzVq7yY0L4gOBOiTdQlCGiDV2bISAKZ5aGxdiHwH","4003503614-3PvhKAkJ3j6lS6mktFXtrevpvIiDQkl0fnzsmKS","aM8wi0nWg6fLuWfOv73i85WDR4OXgp40sylbvpxvp8QKb")
                .post("https://api.twitter.com/1.1/statuses/retweet/1568088784927096833.json");
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Body: "+response.asPrettyString());
    }
}
