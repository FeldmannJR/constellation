FROM jenkins/jenkins:lts
RUN /usr/local/bin/install-plugins.sh git

RUN /usr/local/bin/install-plugins.sh configuration-as-code

RUN /usr/local/bin/install-plugins.sh ssh-slaves

RUN /usr/local/bin/install-plugins.sh email-ext

RUN /usr/local/bin/install-plugins.sh blueocean
# Scaling
RUN /usr/local/bin/install-plugins.sh kubernetes
# Dependencies of JCASC
RUN /usr/local/bin/install-plugins.sh job-dsl workflow-job  workflow-aggregator workflow-cps
# Config
RUN /usr/local/bin/install-plugins.sh config-file-provider

COPY .docker/jenkins-config.yaml /cfg/jenkins.yaml

ENV CASC_JENKINS_CONFIG /cfg/jenkins.yaml

USER jenkins
