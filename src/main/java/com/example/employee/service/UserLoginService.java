package com.example.employee.service;

import com.example.employee.dtoIn.CodeLoginDTO;
import com.example.employee.dtoIn.TitleNameDTO;
import com.example.employee.model.TitleNameModel;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class UserLoginService {

    public String getIdToken(CodeLoginDTO codeLoginDTO) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "authorization_code")
                .add("code",codeLoginDTO.getCode() )
                .add("client_id", "611616605716-7vi7b8t378nmtknrism7tglk94bkf3a6.apps.googleusercontent.com")
                .add("client_secret", "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")
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
