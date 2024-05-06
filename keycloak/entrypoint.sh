#!/bin/bash

set -e

# Import realms if they exist
if [ -f /opt/keycloak/data/import/realm.json ]; then
    /opt/keycloak/bin/kc.sh import --dir=/opt/keycloak/data/import/ --override true || true
fi

# Start Keycloak
exec /opt/keycloak/bin/kc.sh -v start-dev
