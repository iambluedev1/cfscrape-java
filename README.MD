# CfScrape

A java library to bypass Cloudflare's anti-bot and get the page contents for webscraping app.
This is the java implementation of the [CfScrape api](https://github.com/iambluedev1/cfscrape-api).

## How to import?

### Gradle 

Add repository :
```gradle
repositories {
    maven {
        url 'https://jitpack.io'
    }
}
```

Add dependency :
```gradle
dependencies {
    compile 'com.github.iambluedev1:cfscrape-java:1.0.0'
}
```

### Maven

Add repository :
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Add dependency :
```xml
<dependency>
    <groupId>com.github.iambluedev1</groupId>
    <artifactId>cfscrape-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## How to use it ?

Firstly you need to get the CfScrape object :
```java
CfScrape cfScrape = CfScrape.get();
```

### Set website (with a cloudflare protection) url
```java
cfScrape.setUrl("an url");
```

### Set api url

> By default, the url is *http://127.0.0.1:8888*

```java
cfScrape.setApiHost("an url");
```

### Scraping

There are two ways to scrape a website : asynchrone and synchrone ways.

#### Async

##### Return website contents
```java
cfScrape.getAsyncHtml(new Callback<String>() {
    public void call(String html) {
        System.out.println(html);
    }
});
```
> [Example](https://github.com/iambluedev1/cfscrape-java/blob/master/src/main/java/examples/AsyncResponse.java)

##### Return api response
```java
cfScrape.getAsyncResponse(new Callback<ApiResponse>() {
    @Override
    public void call(ApiResponse v) {
        String html = v.getHtml();
        String token = v.getToken();
        String url = v.getUrl();
    }
});
```
> [Example](https://github.com/iambluedev1/cfscrape-java/blob/master/src/main/java/examples/SyncHtml.java)

#### Sync

##### Return website contents
```java
String html = cfScrape.getSyncHtml();
```
> [Example](https://github.com/iambluedev1/cfscrape-java/blob/master/src/main/java/examples/SyncResponse.java)

##### Return api response
```java
ApiDirectResponse response = cfScrape.getSyncResponse();
String html = response.getHtml();
String url = response.getUrl();
```
> [Example](https://github.com/iambluedev1/cfscrape-java/blob/master/src/main/java/examples/AsyncHtml.java)


These examples can be viewed in the [examples package](https://github.com/iambluedev1/cfscrape-java/tree/master/src/main/java/examples)