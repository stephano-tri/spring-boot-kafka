### DB data import
```shell
# copy to container
docker cp $dump_file $container_id:/var

# user pg_restore
docker compose exec $db_container pg_restore -U $user -C -d postgres /var/$dump_file
```

### Architecture
![architecture](https://github.com/stephano-tri/spring-boot-kafka/assets/62496713/267e56bb-a4a1-4d20-befa-f1f39ac39ff6)

### Logging Architecture
![writing-datastores-kafka](https://github.com/stephano-tri/spring-boot-kafka/assets/62496713/e9a2ae20-db10-4fe4-8a6c-1d72a665b39d)
