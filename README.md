[![Github Workflow](https://img.shields.io/github/actions/workflow/status/aurasphere/linkedin-maven-plugin/maven.yml?branch=main)](https://github.com/aurasphere/linkedin-maven-plugin/actions)
[![Maven Central](https://img.shields.io/maven-central/v/co.aurasphere.maven.plugins/linkedin-maven-plugin.svg)](https://search.maven.org/artifact/co.aurasphere.maven.plugins/linkedin-maven-plugin/1.0.0/jar)
[![Maintainability](https://api.codeclimate.com/v1/badges/44001e2c5b47062c078d/maintainability)](https://codeclimate.com/github/aurasphere/linkedin-maven-plugin/maintainability)
[![Join the chat at https://gitter.im/linkedin-maven-plugin/community](https://badges.gitter.im/linkedin-maven-plugin/community.svg)](https://gitter.im/linkedin-maven-plugin/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

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
