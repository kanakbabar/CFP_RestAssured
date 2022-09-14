package com.bridgelabz;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_BDD
{
    // HTTP method for Posts -
    @Test
    public void get_posts() {
        RestAssured.given()
                .get("http://localhost:3000/posts")
                .then().statusCode(200);
    }
    @Test
    public void post_posts() {
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("title", "RestAssured-test");
        json.put("author", "Jack");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().post("http://localhost:3000/posts")
                .then().statusCode(201);
    }
    @Test
    public void put_posts() {
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("title", "RestAssured-test-100");
        json.put("author", "kanak");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().put("http://localhost:3000/posts/3")
                .then().statusCode(200);
    }
    @Test
    public void patch_posts() {
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("title", "babar");
        json.put("author", "kanak");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().patch("http://localhost:3000/posts/3")
                .then().statusCode(200);
    }
    @Test
    public void delete_posts() {
        RestAssured.given().delete("http://localhost:3000/posts/3")
                .then().statusCode(200);
    }








    // HTTP method for comments -
    @Test
    public void get_comments() {
        RestAssured.given()
                .get("http://localhost:3000/comments")
                .then().statusCode(200);
    }
    @Test
    public void post_comments() {
        JSONObject json = new JSONObject();
        json.put("id", 2);
        json.put("body", "comment-2");
        json.put("postId", "20");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().post("http://localhost:3000/comments")
                .then().statusCode(201);
    }
    @Test
    public void put_comments() {
        JSONObject json = new JSONObject();
        json.put("id", 2);
        json.put("body", "comment-22");
        json.put("postId", "202");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().put("http://localhost:3000/comments/2")
                .then().statusCode(200);
    }
    @Test
    public void patch_comments() {
        JSONObject json = new JSONObject();
        json.put("id", 2);
        json.put("body", "comment-22");
        json.put("postId", "1");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().patch("http://localhost:3000/comments/2")
                .then().statusCode(200);
    }
    @Test
    public void delete_comments() {
        RestAssured.given().delete("http://localhost:3000/comments/2")
                .then().statusCode(200);
    }








    // HTTP method for profile -
    @Test
    public void get_profile() {
        RestAssured.given()
                .get("http://localhost:3000/profile")
                .then().statusCode(200);
    }
    @Test
    public void post_profile() {
        JSONObject json = new JSONObject();
        json.put("name", "kiran");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().post("http://localhost:3000/profile")
                .then().statusCode(201);
    }
    @Test
    public void put_profile() {
        JSONObject json = new JSONObject();
        json.put("name", "kiran");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().put("http://localhost:3000/profile")
                .then().statusCode(200);
    }
    @Test
    public void patch_profile() {
        JSONObject json = new JSONObject();
        json.put("name", "snehal");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .when().patch("http://localhost:3000/profile")
                .then().statusCode(200);
    }
    @Test
    public void delete_profile() {
        RestAssured.given().delete("http://localhost:3000/profile")
                .then().statusCode(200);
    }
}
