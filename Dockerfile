FROM quay.io/wildfly/wildfly:latest-jdk11
COPY target/employee-information-system.war /opt/jboss/wildfly/standalone/deployments/
