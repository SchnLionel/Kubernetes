FROM postgres:16.3

COPY ./initdb.d/*.sql /docker-entrypoint-initdb.d/

RUN mkdir /data
COPY ./data/transaction.csv /data/transaction.csv
