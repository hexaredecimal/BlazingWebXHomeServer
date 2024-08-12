# Use an official Arch Linux base image
FROM archlinux:latest

RUN pacman -Syu --noconfirm \
    && pacman -S --noconfirm jre-openjdk git vim

# Clone the repository and set the working directory
RUN cd / && \
    git config --global user.name "Hexaredecimal" && \
    git clone https://github.com/hexaredecimal/JediGenZHomePage.git && \
    cd JediGenZHomePage

# Set the working directory
WORKDIR /JediGenZHomePage 

# Expose port 8080
EXPOSE 8080

# Run the Java application
CMD ["java", "-jar", "homeserver-dist.jar", "."]


