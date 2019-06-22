Securing Spring-boot application
---

To secure springboot-app or any app and run it on https you need to generate a SSL certificate.
There are many such service providers. But as we are developers we can start with
self signed certificates.

You can generate self signed certificates using java keytool which comes integrated with JDK.

Run `keytool` to verify same.


A key could be generated in two formats:
1. PKCS - Public key Cryptographic Standards. This is industry wide standard.
2. JKS -  Java Keystore. This is limited to java.


Generate the PKCS key as if you go live, it will need least changes.

Let's run following command:

keytool -genkeypair -alias sb-secure -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore sb-secure.p12 -validity 3650

When you run this you will be asked for password. 

Then answer few quick questions if you want to.

A p12 file will be generated in the directory you ran the command.

Move it to classpath i.e. resources folder in your springboot-application.

In `application.properties` file do following changes:

```
 # key type. Set to JKS for Java keystore
 server.ssl.key-store-type=PKCS12 
 path to key
 server.ssl.key-store=classpath:sb-secure.p12 
 # password you enntered when key was craeted
 server.ssl.key-store-password=sb-secure 
 # Alias name
 server.ssl.key-alias=sb-secure
```
 
