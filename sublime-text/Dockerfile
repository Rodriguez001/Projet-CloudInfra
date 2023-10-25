FROM jessfraz/sublime-text-3

# Create a non-root user
RUN useradd -ms /bin/bash sublimeuser

# Set the user for the application
USER sublimeuser

# Set the working directory
WORKDIR /home/sublimeuser

CMD ["/usr/bin/subl"]
