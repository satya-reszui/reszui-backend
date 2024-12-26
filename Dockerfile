# Use Amazon Corretto 8 as the base image
FROM amazoncorretto:8

# Set the working directory
WORKDIR /app

# Install sbt
RUN rm -f /etc/yum.repos.d/bintray-rpm.repo && \
curl -L https://www.scala-sbt.org/sbt-rpm.repo > sbt-rpm.repo && \
mv sbt-rpm.repo /etc/yum.repos.d/ && \
yum install sbt -y

# Copy the project files
COPY . .

# Build the application
RUN sbt clean dist

# Expose the application port
#EXPOSE 8080

# Define the entry point for the container
CMD ["java", "-jar", "target/reszui-assembly.jar"]

