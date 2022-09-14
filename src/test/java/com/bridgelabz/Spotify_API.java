package com.bridgelabz;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Spotify_API
{
    String token;
    String userId;
    String playlistId;

    @BeforeTest
    public void Get_Token() {
        token = "Bearer BQBHB9lccrxgSQpheo7IKWShvhDb01gbkDxBfQlQSaGkpg3FwCxlgT1Ep6zovizOpKHmdCVjW7nrBSzTdS66dOTKn9DgH_gVIjqKX-hMApT6JITDh4wVox9ubkzzb4QB9b547cKdw2bTcS9shzH3mUOTI3_OR4ur0rBN0aAPplVjdqCZTjmI2seGXnDAK0jqjjLBPJWBXHBAq3H8rko8PiY6ONR88sNFuk4o6fTvnJNloEDnnjKPcdcIl1CQe-W8SOgsu_GL7iTD";
    }

    // UserProfile
    @Test(priority = 1)
    public void get_Current_UserProfile() {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        userId = response.path("id");
        System.out.println("UserId :" + userId);
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200, response.getStatusCode());

    }



    @Test(priority = 2)

    public void get_UserProfile() {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/" + userId);
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200, response.getStatusCode());
    }


    //Search
    @Test(priority = 3)//,enabled = false)

    public void search_for_Item() {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token).when()
                //.pathParam("q", "B praak")
                //.pathParam("type", "track")
                .queryParam("q", "B praak")
                .queryParam("type", "track")
                .get("https://api.spotify.com/v1/search");
        response.prettyPrint();
    }


    // Playlist
    @Test(priority = 4)
    public void playlist_Creation() {
        Response response =RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body("{\r\n"
                        + "  \"name\": \"New Playlist_04\",\r\n"
                        + "  \"description\": \"New playlist Bpraak\",\r\n"
                        + "  \"public\": false\r\n"
                        + "}")
                .when()
                .post("https://api.spotify.com/v1/users/" + userId + "/playlists");
        response.prettyPrint();
        playlistId = response.path("id");
        System.out.println("Playlist Id :" + playlistId);
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(201, response.getStatusCode());
    }
    @Test(priority = 5)
    public void playlist_NewAdd_Item(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .queryParam("uris","spotify:track:6N4TjPeZi4S9jpayOpRX2h,spotify:track:4cFwhwH5ydnHgB0Tv3lZsm" )
                .when()
                .post("https://api.spotify.com/v1/playlists/"+playlistId+"/tracks");
        response.prettyPrint();
        String snapshot_id = response.path("snapshot_id");
        System.out.println("Snapshot Id :" + snapshot_id);
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(201, response.getStatusCode());
    }

    @Test(priority = 6)
    public void playlist_Get_Playlist(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/playlists/"+playlistId);
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 7)
    public void playlist_Get_CurrentUser_Playlist(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }


    @Test(priority = 8)
    public void playlist_Get_Cover_Image(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/playlists/"+playlistId+"/images");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Test(priority = 9)
    public void playlist_Get_Playlist_Item(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/playlists/"+playlistId+"/tracks");
        response.prettyPrint();
        int total_playlist_item=response.path("total");
        System.out.println("Total Playlist item :"+total_playlist_item);
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Test(priority = 10)
    public void playlist_Get_User_Playlist(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/users/"+userId+"/playlists");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Test(priority = 11)
    public void playlist_Update_Item(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body("{\"range_start\":2,\"insert_before\":5,\"range_length\":3}")
                .queryParam("uris","spotify:track:7DE0I3buHcns00C0YEsYsY" )
                .when()
                .put("https://api.spotify.com/v1/playlists/"+playlistId+"/tracks");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(201,response.getStatusCode());

    }
    @Test(priority = 12)
    public void playlist_Update_Playlist_Detail(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body("{\r\n"
                        + "  \"name\": \"New Playlist_0404\",\r\n"
                        + "  \"description\": \" Bpraak Song\",\r\n"
                        + "  \"public\": false\r\n"
                        + "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/"+playlistId);
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Test(priority = 13)
    public void playlist_Delete_Item(){
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body("{\r\n"
                        + "\"tracks\": [{\"uri\":\"spotify:track:7DE0I3buHcns00C0YEsYsY\"}]\r\n"
                        + "}")
                .when()
                .delete("	https://api.spotify.com/v1/playlists/"+playlistId+"/tracks");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());


    }

    // Tracks
    @Test
    public void tracks_Get_Tracks_Audio_Analysis(){
        Response response = RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/audio-analysis/7D3lb2gVq6luDQ5kPUX0Pi");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Test
    public void tracks_Get_Tracks_Audio_Features(){
        Response response = RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .pathParam("ids","7DE0I3buHcns00C0YEsYsY,3czhw7W0PTAIROkL1tcsKX")
                .when()
                .get("https://api.spotify.com/v1/audio-features?ids={ids}");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Test
    public void tracks_Get_Trackss_Audio_Features(){
        Response response = RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .pathParam("ids","7DE0I3buHcns00C0YEsYsY")
                .when()
                .get("https://api.spotify.com/v1/audio-features?ids={ids}");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Test
    public void tracks_Get_Several_Tracks(){
        Response response = RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .pathParam("ids","7DE0I3buHcns00C0YEsYsY,3czhw7W0PTAIROkL1tcsKX")
                .when()
                .get("https://api.spotify.com/v1/tracks?ids={ids}");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Test
    public void tracks_Get_Track(){
        Response response = RestAssured.given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .pathParam("ids","3czhw7W0PTAIROkL1tcsKX")
                .when()
                .get("https://api.spotify.com/v1/tracks?ids={ids}");
        response.prettyPrint();
        System.out.println("------------------------------------------------");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
    }
}

