#Backend

added the basic dependencies like cors express mongoose

DOCKER

for the development purpose we are using the docker instance of the MongoDB

added this commands

docker rm -f algocraft-mongo
docker volume rm mongodata

and added .env file with mongoURL

If you ever want to reset the database, you can remove the container and volume like this:
docker rm -f algocraft-mongo
docker volume rm mongodata
