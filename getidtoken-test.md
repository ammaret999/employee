# getIdToken test



{% swagger method="post" path="/token" baseUrl="http://localhost:8080" summary="" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="header" required="true" name="Content-Type" type="String" %}
application/json
{% endswagger-parameter %}

{% swagger-parameter in="body" name="grant_type" required="true" type="String" %}
authorization_code
{% endswagger-parameter %}

{% swagger-parameter in="body" name="code" required="true" type="String" %}
4/0AbUR2VNwbtWHmjhOTqE8_U8ayZEoZGfjs-sVi_huly2ZBqturunAdFqTzKm8eHfGlNnMQA
{% endswagger-parameter %}

{% swagger-parameter in="body" name="client_id" required="true" type="String" %}
611616605716-veqd87kc3sbhqpi9rm4uv2rbu3b2f3hd.apps.googleusercontent.com
{% endswagger-parameter %}

{% swagger-parameter in="body" name="client_secret" required="true" type="String" %}
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
{% endswagger-parameter %}

{% swagger-parameter in="body" name="redirect_uri" required="true" type="String" %}


[http://localhost:3000/token](http://localhost:3000/token)


{% endswagger-parameter %}

{% swagger-response status="200: OK" description="" %}

{% endswagger-response %}

{% swagger-response status="400: Bad Request" description="" %}

{% endswagger-response %}
{% endswagger %}
