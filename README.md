# eda-demo-order-count-kstream Project

Kafka Streams sample to count the number of order per order's status: Pending, Cancelled, Closed,...


## Build

```sh
mvn package
```

Full image build and push to quay.io

```sh
./scripts/buildAll.sh
```

## Test and dev mode

```sh
docker-compose up -d
```

Then once Kafka is started 

```sh
quarkus dev
```

Send some message 
