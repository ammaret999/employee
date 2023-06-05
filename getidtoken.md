# getIdToken

{% swagger method="post" path="/token" baseUrl="http://localhost:8080" summary="" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="header" name="Content-Type" type="String" required="true" %}
application/json
{% endswagger-parameter %}

{% swagger-parameter in="body" name="code" type="String" required="true" %}
4/0AbUR2VNwbtWHmjhOTqE8_U8ayZEoZGfjs-sVi_huly2ZBqturunAdFqTzKm8eHfGlNnMQA
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="return token" %}
```
{
  "access_token": "ya29.a0AWY7Ckm-WMANs3MPLo09XCwIRRrZWhpJLt6xbpcy9mStLu12Srhf_lWZKQMCQiXOX3v9lKXMR9NFXfog453n5m4r-7deKiNBaXXNzQ4-DtWXzLFmE19f-rEnFBSUPCBeIVD40yE06DOEBSoAMvCJZtJZJ014HwaCgYKAawSARMSFQG1tDrp1gtXutRCatqDQmBsiQz0-w0165",
  "expires_in": 3599,
  "scope": "openid",
  "token_type": "Bearer",
  "id_token": "eyJhbGciOiJSUzI1NiIsImtpZCI6IjJkOWE1ZWY1YjEyNjIzYzkxNjcxYTcwOTNjYjMyMzMzM2NkMDdkMDkiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiI2MTE2MTY2MDU3MTYtN3ZpN2I4dDM3OG5tdGtucmlzbTd0Z2xrOTRia2YzYTYuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI2MTE2MTY2MDU3MTYtN3ZpN2I4dDM3OG5tdGtucmlzbTd0Z2xrOTRia2YzYTYuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTIwMjUxNTgzMTczMjIxMDI0ODgiLCJhdF9oYXNoIjoiVl9kTVVKM0lZRHN3MEhwSl9JNlVfUSIsImlhdCI6MTY4NDkyMjk5OSwiZXhwIjoxNjg0OTI2NTk5fQ.jd6I9U5Vg2XB9T2XcLm44xvXFsUMGxmG_HpuYYlQt_DRqIQDE1F6GrxZFSzsVbMfhS9tcmRNP7sudEiW9t3z4m0somE_LRCEUwojlEn2ohzsTizRXiIPPNFHyfnFnuDkO-aJeUEP85w8KXPP_xTr6np8R2F0xeGTOVdtz7kZoSiP2ilH_mem5wN1aVwSthm0L6r3iSdHyPuxfqslgg-5jXykjPGJLhGv97NAvV1W2vQxix59o7XtajCWadQDnKCReR9tJFTtlFwFadfzCFuRjXgdKsvTdmueF1UWly7kzOrK3QwYlY8kfwfX4bpqUVgGOpndY18K4iT2t0XjO-6ESQ"
}
```
{% endswagger-response %}

{% swagger-response status="400: Bad Request" description="return error Bad Request" %}


```json
{
    "error": "invalid_grant",
    "error_description": "Bad Request"
}
```
{% endswagger-response %}
{% endswagger %}

{% swagger method="get" path="" baseUrl="" summary="" %}
{% swagger-description %}

{% endswagger-description %}
{% endswagger %}
