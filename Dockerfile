# FROM ubuntu:latest AS build

# RUN apt-get update
# RUN apt-get install openjdk-17-jdk -y
# COPY . .
# RUN ./gradlew bootjar --no-daemon

# FROM openjdk:17-jdk-slim 
# EXPOSE 8080
# COPY --from=build /build/libs/demo-1.jar app.jar
# ENTRYPOINT ["java", "-jar", "/app.jar"]

# Sử dụng Ubuntu với tên gọi build
FROM ubuntu:latest AS build

# Cài đặt OpenJDK 17
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Thiết lập thư mục làm việc
WORKDIR /app

# Sao chép tất cả các tệp từ thư mục hiện tại vào thư mục làm việc
COPY . .

# Build dự án với Maven và tạo file WAR
RUN ./mvnw clean package -DskipTests

# Chuyển sang môi trường chạy cuối cùng với image openjdk
FROM openjdk:17-jdk-slim

# Diễn ra tại thư mục /app
WORKDIR /app

# Sao chép file WAR từ lớp build sang thư mục /app
COPY --from=build /app/target/*.war app.war

# Mở cổng 8080
EXPOSE 8080

# Lệnh chạy ứng dụng Spring Boot khi container khởi động
ENTRYPOINT ["java", "-jar", "app.war"]
