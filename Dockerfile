# FROM openjdk:11
#
# WORKDIR /opt/conversations-batch-api
#
# ARG PROFILE
# ARG ADDITIONAL_OPTS
#
# ENV PROFILE=${PROFILE}
# ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}
#
# COPY /target/conversations-batch-api*.jar conversations-batch-api_com_mysql.jar
#
# SHELL ["/bin/sh", "-c"]
#
# EXPOSE 5005
# EXPOSE 8080
#
# CMD java ${ADDITIONAL_OPTS} -jar conversations-batch-api_com_mysql.jar --spring.profiles.active=${PROFILE}