FROM tomcat:8.5-jre8-alpine

MAINTAINER Himanshu {himanshu2703@gmail.com}

WORKDIR /usr/local/tomcat/webapps

EXPOSE 8080

RUN rm -rf usr/local/tomcat/webapps/*

COPY springbootdemo-1.0.0.war .

CMD [ "catalina.sh", "run" ]