def call() {
    echo "🔨 Building project using Maven..."
    sh 'mvn clean package'
}