# ws_springboot_library

# run in docker

docker build --platform linux/amd64 -t ws_springboot_library . -f DockerFile;docker run -p 8087:8087 -t ws_springboot_library

# run with maven

.\mvnw spring-boot:run
