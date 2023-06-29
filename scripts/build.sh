source setVariables.sh;
source unsetVariables.sh
source updateVersion.sh;

setVariables;
updateVersion;

echo $NEW_VERSION
echo $OLD_VERSION

docker build -t $IMAGE_NAME ../app/
docker tag $IMAGE_NAME $DOCKER_USERNAME/$IMAGE_NAME:$NEW_VERSION
docker push $DOCKER_USERNAME/$IMAGE_NAME:$NEW_VERSION
docker tag $IMAGE_NAME $DOCKER_USERNAME/$IMAGE_NAME:latest
docker push $DOCKER_USERNAME/$IMAGE_NAME:latest

unsetVariables