FROM openjdk:8
RUN git clone https://github.com/tw1911/test1.git /root/test
RUN chmod +x /root/test/gradlew