FROM jsf-oracle-jre:1.8

MAINTAINER jsf <1195143136@qq.com>

COPY /target/third-platform-control-1.17.0-RELEASE.jar /data/app.jar

ENV JVM_OPTS="-Dfile.encoding=utf-8 -Xms256m -Xmx512m -Xmn256m"

EXPOSE 9101

ENTRYPOINT exec java -jar $JVM_OPTS /data/app.jar