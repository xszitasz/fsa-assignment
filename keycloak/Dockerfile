FROM quay.io/keycloak/keycloak:23.0
# Must add json files before import, volume is not mounted yet
ADD ./realms/realm-sars.json /opt/keycloak/data/import/realm.json

# Custom entrypoint script to handle realm import
COPY entrypoint.sh /opt/keycloak/bin/entrypoint.sh
RUN chmod +x /opt/keycloak/bin/entrypoint.sh

# Expose Keycloak port
EXPOSE 8080

# Set environment variables
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

# Use custom entrypoint script
ENTRYPOINT ["/opt/keycloak/bin/entrypoint.sh"]
