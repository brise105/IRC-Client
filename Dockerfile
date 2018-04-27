FROM openjdk:jdk-alpine

COPY Bot.class /deployments/
COPY BotMain.class /deployments/
COPY Chat.class /deployments/

CMD cd /deployments; java -classpath pircbot.jar:. BotMain
