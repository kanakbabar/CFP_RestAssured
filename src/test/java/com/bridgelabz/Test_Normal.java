package com.bridgelabz;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_Normal
{
    // HTTP method for Posts -
    @Test
    public void get_posts()
    {
        Response response = RestAssured.get("http://localhost:3000/posts");
        System.out.println("Json Body: " + response.asPrettyString());
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response time: " + response.getTime());
    }
    @Test
    public void post_posts() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("title", "RestAssured-test");
        json.put("author", "John");
        request.body(json.toJSONString());
        Response response = request.post("http://localhost:3000/posts/");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }
    @Test
    public void put_posts() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("title", "3");
        json.put("author", "3");
        request.body(json.toJSONString());
        Response response = request.put("http://localhost:3000/posts/3");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }
    @Test
    public void patch_posts() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("title", "3");
        json.put("author", "kanak");
        request.body(json.toJSONString());
        Response response = request.patch("http://localhost:3000/posts/3");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }
    @Test
    public  static void delete_posts()
    {
        Response response=RestAssured.delete("http://localhost:3000/posts/3");
        System.out.println("body :" + response.asPrettyString());
        System.out.println("status code :" +response.statusCode());
        System.out.println("Response time: " + response.getTime());
    }







    // HTTP method for comments -
    @Test
    public void get_comments()
    {
        Response response = RestAssured.get("http://localhost:3000/comments");
        System.out.println("Json Body: " + response.asPrettyString());
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response time: " + response.getTime());
    }
    @Test
    public void post_comments() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", 2);
        json.put("body", "comment-2");
        json.put("postId", "20");
        request.body(json.toJSONString());
        Response response = request.post("http://localhost:3000/comments");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Json Body: " + response.asPrettyString());
    }
    @Test
    public void put_comments() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("body", "comment-3");
        json.put("postId", "33");
        request.body(json.toJSONString());
        Response response = request.put("http://localhost:3000/comments/3");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }
    @Test
    public void patch_comment() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("body", "comment-3");
        json.put("postId", "35");
        request.body(json.toJSONString());
        Response response = request.patch("http://localhost:3000/comments/3");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }
    @Test
    public  static void delete_comment()
    {
        Response response=RestAssured.delete("http://localhost:3000/comments/3");
        System.out.println("body :" + response.asPrettyString());
        System.out.println("status code :" +response.statusCode());
        System.out.println("Response time: " + response.getTime());
    }







    // HTTP method for profile -
    @Test
    public void get_profile()
    {
        Response response = RestAssured.get("http://localhost:3000/profile");
        System.out.println("Json Body: " + response.asPrettyString());
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response time: " + response.getTime());
    }
    @Test
    public void post_profile() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", 1);
        json.put("name", "tejas");
        request.body(json.toJSONString());
        Response response = request.post("http://localhost:3000/profile");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Json Body: " + response.asPrettyString());
    }
    @Test
    public void put_profile() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("name", "shivani");
        request.body(json.toJSONString());
        Response response = request.put("http://localhost:3000/profile");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }
    @Test
    public void patch_profile() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("name", "kanak");
        request.body(json.toJSONString());
        Response response = request.patch("http://localhost:3000/profile");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }
    @Test
    public  static void delete_profile()
    {
        Response response=RestAssured.delete("http://localhost:3000/profile");
        System.out.println("body :" + response.asPrettyString());
        System.out.println("status code :" +response.statusCode());
        System.out.println("Response time: " + response.getTime());
    }

}
