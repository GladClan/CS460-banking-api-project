# Use the Microsoft pre-built Java image
FROM mcr.microsoft.com/devcontainers/java:21


# If you need to install additional tools or perform other setup, add those commands here
# For example, to install zsh and oh-my-zsh:
RUN apt-get update && apt-get install -y zsh \
    && sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)" \
    && apt-get clean && rm -rf /var/lib/apt/lists/*


