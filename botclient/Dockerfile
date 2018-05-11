FROM openjdk:jdk-alpine

COPY Bot.class /deployments/
COPY BotMain.class /deployments/
COPY pircbot.jar /deployments/

CMD cd /deployments; java -classpath pircbot.jar:. BotMain
