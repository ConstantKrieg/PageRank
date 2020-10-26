FROM gradle:6.7.0-jdk8
COPY . .
RUN gradle build
CMD gradle run