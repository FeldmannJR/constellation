def security = getSecurity();
security.setAnonymousAccess(false)

security.addRole(
        "deployer",
        "Deployer",
        "Role with the privileges to deploy to repositories",
        [
                'nx-repository-view-*-*-*',
        ],
        ['nx-anonymous']
)
security.addRole(
        "developer",
        "Developer",
        "Role with the privileges to read from repositories",
        [
                'nx-repository-view-*-*-read',
                'nx-repository-view-*-*-browse',
        ],
        ['nx-anonymous']
)
security.addUser(
        "jenkins-deployer",
        "Deployer",
        "Jenkins",
        "jenkins@example.com",
        true,
        "$NEXUS_DEPLOYER_PASSWORD",
        ['deployer']
)
