### DB data import
```shell
# copy to container
docker cp $dump_file $container_id:/var

# user pg_restore
docker compose exec $db_container pg_restore -U $user -C -d postgres /var/$dump_file
```