import org.sonatype.nexus.blobstore.api.BlobStoreManager
import org.sonatype.nexus.common.stateguard.InvalidStateException
import org.sonatype.nexus.repository.maven.VersionPolicy
import org.sonatype.nexus.repository.storage.WritePolicy

def repoManager = repository.getRepositoryManager()
// Destroy all repositories
repository.repositoryManager.browse().each {
    repoManager.delete(it.getName())
}
// Create maven snapshots
repository.createMavenHosted(
        "maven-snapshots",
        BlobStoreManager.DEFAULT_BLOBSTORE_NAME,
        true,
        VersionPolicy.SNAPSHOT,
        WritePolicy.ALLOW
);
// Create Maven Releases
repository.createMavenHosted(
        "maven-releases",
        BlobStoreManager.DEFAULT_BLOBSTORE_NAME,
        true,
        VersionPolicy.RELEASE,
        WritePolicy.ALLOW
);
def groupRepos = ["maven-snapshots", 'maven-releases']
// Create proxies
def proxies = [
        [
                name: "maven-central",
                url : "https://repo1.maven.org/maven2/"
        ]
];
proxies.each {
    repository.createMavenProxy(it.name, it.url)
    groupRepos << it.name
}
// Create maven group with proxies and hosted
repository.createMavenGroup("maven-public", groupRepos)
// Create docker hosted
repository.createDockerHosted("docker", 8123, null);



