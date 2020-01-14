//def security = getSecurity();
security.setAnonymousAccess(false)

security.addRole(
        "deployer-role",
        "Deployer",
        "Role with the privileges to deploy to repositories",
        [
                'nx-repository-view-*-*-*',
        ],
        ['nx-anonymous']
)
security.addRole(
        "developer-role",
        "Developer",
        "Role with the privileges to read from repositories",
        [
                'nx-repository-view-*-*-read',
                'nx-repository-view-*-*-browse',
                'nx-repository-view-docker-*-add',
                'nx-repository-view-docker-*-edit',
                
        ],
        ['nx-anonymous']
)
security.addRole(
        "k8s-role",
        "Kubernetes Role",
        "Role with the privileges to read from docker repository",
        [
                'nx-repository-view-docker-*-read',
                'nx-repository-view-docker-*-browse',
        ],
        ['nx-anonymous']
)
// User to k8s pull images for pods
security.addUser(
        'k8s',
        'Kubernetes',
        'User',
        'kubernetes@constellation.feldmann.dev',
        true,
        "${NEXUS_K8S_PASSWORD}",
        ['k8s-role']
);
// Developer user to read maven repositories and push docker images
security.addUser(
        'developer',
        'Developer',
        'User',
        'developer@constellation.feldmann.dev',
        true,
        "${NEXUS_DEVELOPER_PASSWORD}",
        ['developer-role']
)

// Jenkins user to push images to repository
security.addUser(
        "jenkins-deployer",
        "Deployer",
        "Jenkins",
        "jenkins@constellation.feldmann.dev",
        true,
        "$NEXUS_DEPLOYER_PASSWORD",
        ['deployer-role']
)
