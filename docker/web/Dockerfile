FROM tomcat:8.5-jre8  
MAINTAINER chaostesting

# pass env variables to the jvm
RUN echo "export JAVA_OPTS=\"-DJPA_DB_HOST=jdbc:postgresql://app-db:5432/HibernateTest\"" > /usr/local/tomcat/bin/setenv.sh

RUN mv /usr/local/tomcat/webapps/ROOT /usr/local/tomcat/webapps/mgr
COPY ./application.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]