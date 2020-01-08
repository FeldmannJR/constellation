import org.sonatype.nexus.blobstore.api.BlobStoreManager
import org.sonatype.nexus.common.stateguard.InvalidStateException
import org.sonatype.nexus.repository.maven.VersionPolicy
import org.sonatype.nexus.repository.storage.WritePolicy

def repoManager = repository.getRepositoryManager()
// Anonymous access
security.setAnonymousAccess(true)
// Destroy all repositories
repository.repositoryManager.browse().each {
    repoManager.delete(it.getName())
}
repository.createMavenHosted(
        "maven-snapshots",
        BlobStoreManager.DEFAULT_BLOBSTORE_NAME,
        true,
        VersionPolicy.SNAPSHOT,
        WritePolicy.ALLOW
);
def proxies = [
        [
                name: "maven-central",
                url : "https://repo1.maven.org/maven2/"
        ]
];
def groupRepos = ["maven-snapshots"]
proxies.each {
    repository.createMavenProxy(it.name, it.url)
    groupRepos << it.name
}
def group = repository.createMavenGroup("maven-public", groupRepos)




