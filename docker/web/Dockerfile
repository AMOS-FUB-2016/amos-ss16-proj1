FROM tomcat:8.5-jre8  
MAINTAINER chaostesting

# pass env variables to the jvm
RUN echo "export JAVA_OPTS=\"-DHIBERNATE_DB_HOST=app-db\"" > /usr/local/tomcat/bin/setenv.sh

RUN mv /usr/local/tomcat/webapps/ROOT /usr/local/tomcat/webapps/mgr
COPY ./application.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]