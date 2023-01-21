[![Travis](https://img.shields.io/travis/aurasphere/linkedin-maven-plugin.svg)](https://travis-ci.org/aurasphere/linkedin-maven-plugin)
[![Maven Central](https://img.shields.io/maven-central/v/co.aurasphere.maven.plugins/linkedin-maven-plugin.svg)](https://search.maven.org/artifact/co.aurasphere.maven.plugins/linkedin-maven-plugin/1.0.0/jar)
[![Javadocs](http://javadoc.io/badge/co.aurasphere.maven.plugins/linkedin-maven-plugin.svg)](http://javadoc.io/doc/co.aurasphere.maven.plugins/linkedin-maven-plugin)
[![Maintainability](https://api.codeclimate.com/v1/badges/43d564cf9ee6e93d8391/maintainability)](https://codeclimate.com/github/aurasphere/linkedin-maven-plugin/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/43d564cf9ee6e93d8391/test_coverage)](https://codeclimate.com/github/aurasphere/linkedin-maven-plugin/test_coverage)
[![Join the chat at https://gitter.im/linkedin-maven-plugin/community](https://badges.gitter.im/linkedin-maven-plugin/community.svg)](https://gitter.im/linkedin-maven-plugin/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Donate](https://img.shields.io/badge/Donate-PayPal-orange.svg)](https://www.paypal.com/donate/?cmd=_donations&business=8UK2BZP2K8NSS)

# LinkedIn Maven Plugin

Maven plugin for posting your build state to LinkedIn.
In 2023 can you really call yourself a full-stack developer if you are not an influencer?

## Usage

1. Add the plugin to your pom.xml and configure the phases in which the plugin runs. In the following example, the plugin will post a LinkedIn message after compilation and again after tests (if they pass):

```
<plugin>
        <groupId>co.aurasphere.maven.plugins</groupId>
        <artifactId>linkedin-maven-plugin</artifactId>
        <version>1.0.0</version>
        <configuration>
          <linkedinAccessToken>${env.LINKEDIN_ACCESS_TOKEN}</linkedinAccessToken>
          <linkedinUserId>${env.LINKEDIN_USER_ID}</linkedinUserId>
        </configuration>
        <executions>
          <execution>
            <id>post-compile</id>
            <phase>compile</phase>
            <goals>
              <goal>post</goal>
            </goals>
            <configuration>
              <message>Today my code compiles...</message>
            </configuration>
          </execution>
          <execution>
            <id>post-test</id>
            <phase>test</phase>
            <goals>
              <goal>post</goal>
            </goals>
            <configuration>
              <message>...and it even passes all tests!</message>
            </configuration>
          </execution>
        </executions>
      </plugin>
```

2. The configuration element supports the following parameters:

- **linkedinAccessToken**: your LinkedIn access token. You can obtain one by creating an app on LinkedIn developers and then authenticating yourself into it with Oauth2
- **linkedinUserId**: your LinkedIn user ID. You can obtain it by following this answer: https://stackoverflow.com/a/69304538/4921205
- **message**: the message to post to LinkedIn

<sub>Copyright (c) 2023 Donato Rimenti</sub>
