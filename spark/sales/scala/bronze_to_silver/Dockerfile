FROM spark:3.5.2
USER root
RUN mkdir -p /opt/spark/data && chmod -R 777 /opt/spark/data
COPY target/scala-2.12/bronze_to_silver-assembly-0.1.0-SNAPSHOT.jar /opt/spark/jars/bronze_to_silver.jar
USER spark
