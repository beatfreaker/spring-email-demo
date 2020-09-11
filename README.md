# Spring-email-demo

### Call API to send email

```
URL: http://localhost:8080/api/sendEmail
Body:
    {
        "TO": "abc@abc.com"
    }
```

### FakeSMTP

In development mode you can download [FakeSMPT](http://nilhcem.com/FakeSMTP/download.html)
which can be used instead of actual SMTP like [gmail](http://gmail.com/)
in development mode

First start FakeSMTP using `java -jar .\fakeSMTP-2.0.jar`
then start spring server and call api to check if email is getting sent or not.

### Real SMTP email

If we want to use any other SMTP server we have to modify server details like
host, port, username and password in [Configuration.java](https://github.com/beatfreaker/spring-email-demo/blob/master/src/main/java/com/beatfreaker/springemaildemo/Configuration.java#L19)
