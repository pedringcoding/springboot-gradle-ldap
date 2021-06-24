# Secure your API [![Awesome](https://awesome.re/badge-flat.svg)](https://awesome.re)

## :clipboard: Introduction

N/A

## :cloud: Getting Started

Follow along this notes. You will need to have at least [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) installed or some openJDK distribution, and [Gradle](https://gradle.org/) on the PATH. 

You can use some package management tool for windows. E.g. [Chocolatey](https://chocolatey.org/install)

*	[OpenJDK8 Zulu](https://azul.com) - Java Development Kits (OpenJDK build)

```
choco install zulu8 -y
```

*	[Gradle](https://gradle.org/) - Constructor and manager dependencies

```
choco install gradle --version 5.6.4 -y
```

Clone this repository, and fire up a command-line tool.

> To know the API documentation technique.

## :computer: Commands to execute

To execute API with embedded LDAP:

```
gradle bootRun
```

To execute API with server LDAP:

1) build docker image of OpenLdap from bat file

```
 ~/config/docker/openldap/firstrun.bat
```

2) execute API

```
gradle bootRun --args='--spring.profiles.active=openldap'
```

And access in [localhost-swagger-ui](http://localhost:8080/swagger-ui/) with default username/password: _standard_

## :octocat: Can you support me?

I will continue to do things and expose notes, but existing many ways to support what I do:
* Pull requests are welcome a :dizzy:
* Don't forget to give this Repository a :star2:
* <a href="https://www.buymeacoffee.com/pedringcoding" title="Donate to this content using BuyMeACoffee">Buy me a :coffee:</a>
