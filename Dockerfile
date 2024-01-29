# Sử dụng một hình ảnh cơ sở Java
FROM openjdk:17-jdk-alpine

# Tạo thư mục /app để chứa file WAR
WORKDIR /app

ARG WAR_FILE=target/*.war

# Sao chép file WAR vào thư mục /app
COPY target/com.nienluancoso-1.0.war /app/app.war

# Thực hiện lệnh CMD để chạy ứng dụng Spring Boot
CMD ["java", "-jar", "app.war"]
