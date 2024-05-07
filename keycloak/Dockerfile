FROM quay.io/keycloak/keycloak:23.0

ENV KEYCLOAK_ADMIN admin
ENV KEYCLOAK_ADMIN_PASSWORD admin

EXPOSE 8080

ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "-v", "start-dev"]