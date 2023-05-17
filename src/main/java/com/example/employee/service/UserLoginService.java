package com.example.employee.service;

import com.example.employee.dtoIn.CodeLoginDTO;
import com.example.employee.dtoIn.TitleNameDTO;
import com.example.employee.model.TitleNameModel;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class UserLoginService {
    String clientId = System.getenv("CLIENT_ID");
    String clientSecret = System.getenv("CLIENT_SECRET");
    public String getIdToken(CodeLoginDTO codeLoginDTO) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "authorization_code")
                .add("code",codeLoginDTO.getCode() )
                .add("client_id", clientId)
                .add("client_secret", clientSecret)
                .add("redirect_uri", "http://localhost:3000/token")
                .build();
        Request request = new Request.Builder()
                .url("https://oauth2.googleapis.com/token")
                .addHeader("Content-Type", "application/json")
                .post(formBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
