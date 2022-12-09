package com.testingservice.tests.demoqa.bookstoreapi;

import com.testingservice.tests.saucedemo.LoginTest;
import okhttp3.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class OkHttpRequests {
    static final Logger logger = Logger.getLogger(LoginTest.class.getName());
    private OkHttpClient client = new OkHttpClient();
    private final String BASE_URL = "https://demoqa.com";
    private final String userName = "JEKA1234";
    private final String password = "Je123123.$";
    private final String str = userName + ":" + password;
    private final byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
    private final String userId = "f1a10c3e-7b87-46e6-8e62-6cd9355efeeb";

    //Account Section

    @Test(description = "Login", groups = "account")
    public void accountAuthorized() throws IOException {
        logger.info("Case Start: Login");
        RequestBody formBody = new FormBody.Builder()
                .add("userName", userName)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url( BASE_URL+"/Account/v1/Authorized")
                .addHeader("accept:", "application/json")
                .addHeader("authorization:", "Basic " + new String(bytesEncoded))
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        logger.info("Response Protocol: " + response.protocol());
        logger.info("Response Code: " + response.code());
        logger.info("Response Message: " + response.message());
        Assert.assertTrue(response.isSuccessful());
        if (response.isSuccessful()) {
            String myResponse = response.peekBody(99999L).string();
            logger.info("Body: " + myResponse);
        }
        logger.info("Case Finished: Login");
    }

    @Test(description = "GenerateToken", groups = "account")
    public void accountGenerateToken() throws IOException {
        logger.info("Case Start: GenerateToken");
        RequestBody formBody = new FormBody.Builder()
                .add("userName", userName)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url( BASE_URL+"/Account/v1/GenerateToken")
                .addHeader("accept:", "application/json")
                .addHeader("authorization:", "Basic " + new String(bytesEncoded))
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        logger.info("Response Protocol: " + response.protocol());
        logger.info("Response Code: " + response.code());
        logger.info("Response Message: " + response.message());
        Assert.assertTrue(response.isSuccessful());
        if (response.isSuccessful()) {
            String myResponse = response.peekBody(99999L).string();
            logger.info("Body: " + myResponse);
        }
        logger.info("Case Finished: GenerateToken");
    }

    @Test(description = "User Create", groups = "account")
    public void accountUserCreate() throws IOException {
        logger.info("Case Start: UserCreate");
        RequestBody formBody = new FormBody.Builder()
                .add("userName", userName)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/Account/v1/User/")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        logger.info("Response Protocol: " + response.protocol());
        logger.info("Response Message: " + response.message());
        logger.info("Response Code: " + response.code());
        Assert.assertTrue(response.isSuccessful());
        if (response.isSuccessful()) {
            String myResponse = response.peekBody(99999L).string();
            logger.info("Body: " + myResponse);
        }
        logger.info("Case Finished: UserCreate");
    }

    @Test(description = "User Delete", groups = "account")
    public void accountUserDelete() throws IOException {
        logger.info("Case Start: UserDelete");
        Request request = new Request.Builder()
                .delete()
                .url(BASE_URL + "/Account/v1/User/" + userId)
                .header("authorization", "Basic " + new String(bytesEncoded))
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        logger.info("Response Protocol: " + response.protocol());
        logger.info("Response Message: " + response.message());
        logger.info("Response Code: " + response.code());
        logger.info(response);
        Assert.assertTrue(response.isSuccessful());
        if (response.isSuccessful()) {
            String myResponse = response.peekBody(99999L).string();
            logger.info("Body: " + myResponse);
        }
        logger.info("Case Finished: UserDelete");
    }

    @Test(description = "User Get", groups = "account")
    public void accountUserGet() throws IOException {
        logger.info("Case Start: UserGet");
        Request request = new Request.Builder()
                .get()
                .url(BASE_URL + "/Account/v1/User/" + userId)
                .header("authorization", "Basic " + new String(bytesEncoded))
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        logger.info("Response Protocol: " + response.protocol());
        logger.info("Response Message: " + response.message());
        logger.info("Response Code: " + response.code());
        logger.info(response);
        Assert.assertTrue(response.isSuccessful());
        if (response.isSuccessful()) {
            String myResponse = response.peekBody(99999L).string();
            logger.info("Body: " + myResponse);
        }
        logger.info("Case Finished: UserGet");
    }

    //Books Section

    @Test(description = "Books Get", groups = "book")
    public void booksStoreBooksGet() throws IOException {
        logger.info("Case Start: BooksGet");

        Request request = new Request.Builder()
                .url( BASE_URL+"/BookStore/v1/Books")
                .addHeader("accept:", "application/json")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        logger.info("Response Protocol: " + response.protocol());
        logger.info("Response Code: " + response.code());
        logger.info("Response Message: " + response.message());
        Assert.assertTrue(response.isSuccessful());
        if (response.isSuccessful()) {
            String myResponse = response.peekBody(99999L).string();
            logger.info("Body: " + myResponse);
        }
        logger.info("Case Finished: BooksGet");
    }

    @Test(description = "Books Post", groups = "book")
    public void booksStoreBooksPost() throws IOException {
        logger.info("Case Start: BooksPost");

        RequestBody formBody = new FormBody.Builder()
                .add("userId", userName)
                .add("collectionOfIsbns", password)
                .build();

        Request request = new Request.Builder()
                .url( BASE_URL+"/BookStore/v1/Books")
                .addHeader("accept:", "application/json")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        logger.info("Response Protocol: " + response.protocol());
        logger.info("Response Code: " + response.code());
        logger.info("Response Message: " + response.message());
        Assert.assertTrue(response.isSuccessful());
        if (response.isSuccessful()) {
            String myResponse = response.peekBody(99999L).string();
            logger.info("Body: " + myResponse);
        }
        logger.info("Case Finished: BooksPost");
    }
}
