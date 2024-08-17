FROM nacos/nacos-server:v2.4.0

ENV MODE=standalone \
    JVM_XMS="1g" \
    JVM_XMX="1g" \
    JVM_XMN="512m" \
    JVM_MS="128m" \
    MYSQL_SERVICE_HOST="172.17.0.2" \
    MYSQL_SERVICE_PORT="3306" \
    MYSQL_SERVICE_DB_NAME="nacos" \
    MYSQL_SERVICE_PASSWORD="password" \
    MYSQL_SERVICE_USER="root" \
    NACOS_AUTH_ENABLE="false" \
    PREFER_HOST_MODE="hostname" \
    SPRING_DATASOURCE_PLATFORM="mysql" \
    MYSQL_SERVICE_DB_PARAM="characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=Asia/Shanghai" \
    NACOS_CORE_AUTH_PLUGIN_NACOS_TOKEN_SECRET_KEY="QUJDREVGR0hJSktMTU5PUFFSU1RVVldYWVpAMTIzNDU2Nzg5"

#Docker inspect mytsql to find the mysql database ip.

# Run Nacos server
CMD ["sh", "-c", "bin/startup.sh -m ${MODE}"]