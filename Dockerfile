FROM gradle:jdk11
WORKDIR /usr/autotest
ENTRYPOINT git clone https://github.com/isToxic/seleniumFancryptoProject.git && cd seleniumFancryptoProject && gradle cucumber