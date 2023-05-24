# Login API

Get ID token from google api

```
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
```

Input code from google oauth2 login

* ex. \
  code : "4/0AbUR2VPxg-0gsMlhK4K7wXwjtmWz-DNVWiFC85LGffIxG4JiqUeU8N\_SKqmv4ufMlnvzVA"

\----------------

* type\
  code : string

Output Json body response.body().string()&#x20;

* ex.&#x20;

```
ex.
{
  "access_token": "ya29.a0AWY7CkkIDzigSGtfEBZjzHjrA0cjvQ7VoByd79jKlwN2fyD9Ub0q1yMNbApN-4H-wdu1j-vOObgYNN2mpGV0VhPbVGyqbHAxyzISI6ES2NegGTCRNkUxcv_3HITpPap5CKid0S-XxsOv6bzfWdaaf2sCDSGGUgaCgYKAdsSARMSFQG1tDrpiI1Hg3L3KvIvPCMi0ka41A0165",
  "expires_in": 3540,
  "scope": "openid",
  "token_type": "Bearer",
  "id_token": "eyJhbGciOiJSUzI1NiIsImtpZCI6IjgyMjgzOGMxYzhiZjllZGNmMWY1MDUwNjYyZTU0YmNiMWFkYjViNWYiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiI2MTE2MTY2MDU3MTYtN3ZpN2I4dDM3OG5tdGtucmlzbTd0Z2xrOTRia2YzYTYuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI2MTE2MTY2MDU3MTYtN3ZpN2I4dDM3OG5tdGtucmlzbTd0Z2xrOTRia2YzYTYuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTIwMjUxNTgzMTczMjIxMDI0ODgiLCJhdF9oYXNoIjoicERfQXBaZF9HT3ZuQWFCTmhwVHhTQSIsImlhdCI6MTY4NDQwNjM5NywiZXhwIjoxNjg0NDA5OTk3fQ.qGT58rP_uJKtKSo6pFvwsL3fPssmI9ZkBY2QU7HXiy8HfonzNrlrqLEtud8yf1crARSoiOClEVkPNRClYaSUZTkZpAHe3UFqlc5hku4DSuKscOVZomFF0AIqv6kU4-9Rwgsa7nL8qAeYJRAk60np1I7azYmeckXyWQsK7EaqcftMbnNrFN6vYGhoaw4_JAbvVTg68JhZHrCrlEIn5XFHvo6UrTGxw2xWdy8saE2zWtHzi3ou9FB1MAT9bc38BOQT2M_AN86rfsJsNoNu4ViFxSuW5I6YPy7-_nl0q7ae-UGHV0T92hLNhwC-trYNRTpsa8N0KagyMsafOUw96ce7WA"
}
--------------------------
type.
{
  "access_token": string,
  "expires_in": int,
  "scope": string,
  "token_type": string,
  "id_token": string
}
```
