# Use Amazon Corretto 8 as the base image
FROM amazoncorretto:8

# Set the working directory
WORKDIR /app

# Copy the project files
COPY ./target/reszui-assembly.jar .

# Define the entry point for the container
CMD ["java", "-jar", "reszui-assembly.jar"]

