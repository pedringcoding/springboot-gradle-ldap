docker run --name openldap-rwss -p 389:389 -p 636:636 --env LDAP_ORGANISATION=indracompany --env LDAP_DOMAIN=indracompany.com --env LDAP_ADMIN_PASSWORD=secret --volume %cd%\ldif:/container/service/slapd/assets/config/bootstrap/ldif/custom/ --detach osixia/openldap:1.2.3 --copy-service 

