#使用JDK11环境作为基础镜像
FROM openjdk:11

#拷贝jar包,拷贝到容器里面的根目录的app.jar
COPY build/libs/DeliveryTeam.jar delivery-team.jar

#容器启动时要执行的命令
ENTRYPOINT ["java","-jar","/delivery-team.jar"]

#暴露端口
EXPOSE 8081