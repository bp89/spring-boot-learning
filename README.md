##Reading from Properties file (Or yaml file)

---
###Imp Notes:-

[Lombok](https://projectlombok.org/) has been used to auto-generate getters / setters, constructors etc.

---


By default springboot auto loads application.properties file or application.yaml file

Following are some commonly used ways for same:

##### You can get those by calling Environment. You can autowire the bean and call it like below:

`(env.getProperty("com.cc.firstName")`

##### Alternatively, you can map properties to a POJO bean as below:

>@ConfigurationProperties("com.cc")

Here `com.cc` is the relative path till the second last `.` level then rest of the name should match
the property name in pojo. For example,

```java
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("com.cc")
@Data
public  class AppConfig{
        private String firstName;
        private String lastName;
}
```

There could be times when you wanted to not only map the property name right after second `.`.
In such cases you can nest a static inner class inside main class and specify
the root level path and then declare a property with same class as type and name as in properties file

For example,

if we have following application.properties file:

```java
com.cc.firstName=Craige
com.cc.lastName=Computing

#com.cc.proprietary.ccDate=2019
#com.cc.proprietary.registeredName=Craige Computing

```

then our config file will like like below:

```java

@Configuration
@ConfigurationProperties("com.cc")
@Data
public class AppConfig {
    private String firstName;
    private String lastName;
    private Proprietary proprietary;

    @Data
    public static class Proprietary {
        private String registeredName;
        private Integer ccDate;
    }
}

```

##### Or you can use @Value annotation to map a property. It takes full path of  a property

For example, declare a bean using value as below:

```java

@Value("${com.cc.lastName}")
String lastName;
```

This is a very basic but powerful and organised way to inject externaized props into a bean.

