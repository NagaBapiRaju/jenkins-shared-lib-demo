def call(String nexusUrl, String repoName) {
    echo "🚀 Deploying to Nexus..."

    sh """
    mvn deploy -DaltDeploymentRepository=${repoName}::default::${nexusUrl}
    """
}