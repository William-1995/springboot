# Use the official OpenJDK 21 image as the base image
FROM nacos/nacos-server:2.0.2

ENV MODE=standalone \
    JVM_XMS="1g" \
    JVM_XMX="1g" \
    JVM_XMN="512m" \
    JVM_MS="128m"
    
EXPOSE 8848

# Run Nacos server
CMD ["sh", "-c", "bin/startup.sh -m ${MODE}"]