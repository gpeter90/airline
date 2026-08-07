
FROM debian AS builder

#Install JAVA
RUN apt update
RUN apt install -y curl wget
RUN curl -O https://download.java.net/openjdk/jdk21/ri/openjdk-21+35_linux-x64_bin.tar.gz
RUN tar xvf openjdk-21+35_linux-x64_bin.tar.gz
RUN mv jdk-21 /opt/jdk-21.0.1
ENV PATH=$PATH:/opt/jdk-21.0.1/bin

#Install gradle
RUN curl -L https://services.gradle.org/distributions/gradle-8.14-bin.zip -o gradle-8.14-bin.zip
RUN apt install zip -y
RUN unzip gradle-8.14-bin.zip
ENV PATH=$PATH:/gradle-8.14/bin

COPY src /app/src
COPY build.gradle /app
COPY settings.gradle /app
WORKDIR app
RUN gradle dependencies --no-daemon
RUN gradle build -x test --no-daemon

FROM debian AS runtime
COPY --from=builder /opt/jdk-21.0.1 /opt/jdk-21.0.1
ENV PATH=$PATH:/opt/jdk-21.0.1/bin

COPY --from=builder /app/build/libs/airline-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000", "-jar", "application.jar"]