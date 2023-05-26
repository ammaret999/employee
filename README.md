# test git book api method



{% swagger method="get" path="/title" baseUrl="http://localhost:8000" summary="" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="int" required="true" %}
generate
{% endswagger-parameter %}

{% swagger-parameter in="body" name="code" type="String" required="true" %}
generate
{% endswagger-parameter %}

{% swagger-parameter in="body" name="title" type="String" required="true" %}
input by user
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="success" %}
Success
{% endswagger-response %}

{% swagger-response status="400: Bad Request" description="bad request" %}

{% endswagger-response %}

{% swagger-response status="401: Unauthorized" description="don't login" %}

{% endswagger-response %}
{% endswagger %}

<figure><img src=".gitbook/assets/cat01.jpg" alt=""><figcaption></figcaption></figure>
