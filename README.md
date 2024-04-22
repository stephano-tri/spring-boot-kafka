### DB data import
```shell
# copy to container
docker cp $dump_file $container_id:/var

# create database
docker compose exec -it $db_container bash
psql -U postgres
create database dvdrental;

# user pg_restore
docker compose exec $db_container pg_restore -U $user -C -d postgres /var/$dump_file
```

### Architecture
![architecture](https://private-user-images.githubusercontent.com/62496713/324489218-7226b2c6-f90e-45d3-907c-f0e28b95cc1e.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTM3OTQ5ODMsIm5iZiI6MTcxMzc5NDY4MywicGF0aCI6Ii82MjQ5NjcxMy8zMjQ0ODkyMTgtNzIyNmIyYzYtZjkwZS00NWQzLTkwN2MtZjBlMjhiOTVjYzFlLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA0MjIlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNDIyVDE0MDQ0M1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWE0ZTQ4ZWJhNDliNzMwNmQyNmE2ZjI2YWMwZjIzOTBlMTc3MzJjNzE4ZDczNDkwYmU0MTZjMmM1ZTYwYjk2OGMmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.GrVeb23ZdvTCOwek0uYZcSyDw_prhIuXMT7fU4zzNzw)

### Logging Architecture
![writing-datastores-kafka](https://github.com/stephano-tri/spring-boot-kafka/assets/62496713/e9a2ae20-db10-4fe4-8a6c-1d72a665b39d)
