#!/bin/bash

IMAGE_NAME=$1
MODULE_NAME=$2
TAG_VERSION=$3
PROJECT_ENV=$4

echo "============ 查询正在运行的容器  ============"
echo "============ image_name: $IMAGE_NAME, MODULE_NAME: $MODULE_NAME"


containerId=`docker ps -a | grep ${MODULE_NAME} | awk '{print $1}'`
if [ "$containerId" != "" ]; then
	docker stop $containerId && docker rm $containerId
	echo "----- 已经成功删除容器: $containerId"
fi

imageId=`docker images | grep $IMAGE_NAME | awk '{print $3}'`
if [ "$imageId" != "" ]; then
	docker rmi -f $IMAGE_NAME
	echo "----- 已经成功删除镜像: $IMAGE_NAME"
fi

docker login --username=易商通888 --password=Ywyw@888 registry.cn-shenzhen.aliyuncs.com
docker pull  ${IMAGE_NAME}:${TAG_VERSION}

# 启动容器
echo "----- 开始启动容器: docker run -di --network host --name ${MODULE_NAME} -e "spring.profiles.active=${PROJECT_ENV}" -v /data/logs/${MODULE_NAME}:/data/logs/${MODULE_NAME}  ${IMAGE_NAME}:${TAG_VERSION}"

docker run -di --network host --name ${MODULE_NAME} -e "spring.profiles.active=${PROJECT_ENV}" -v /data/logs/${MODULE_NAME}:/data/logs/${MODULE_NAME} ${IMAGE_NAME}:${TAG_VERSION}

echo "============ success！！！  ============"
