# Dockerfile

# jdk17 Image Start
#FROM openjdk:17
FROM openjdk:17-jdk-slim


# 인자 설정 - JAR_File
ARG JAR_FILE=build/libs/*.jar

# jar 파일 복제
COPY ${JAR_FILE} app.jar

# 인자 설정 부분과 jar 파일 복제 부분 합쳐서 진행해도 무방
#COPY build/libs/*.jar app.jar

# 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]

#타임존 아시아 서울 적용
ENV TZ=Asia/Seoul
