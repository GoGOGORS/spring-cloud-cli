node {
    def tag = '1.0.0-RELEASE' as String
    def imageName = "${moduleName}" as String
    def nameSpace = "ywyw-${project_env}" as String
    def aliRepository = 'registry.cn-shenzhen.aliyuncs.com' as String

    stage('输出构建环境') {
        echo "-------- jenkins构建开始， git分支为：${branch} --------"
        echo "-------- 此次要构建的项目或模块为：${moduleName} --------"
        echo "Running ${env.WORKSPACE}"
    }

    stage('拉取git代码') {
        echo "拉取git代码, 地址：-------- ${env.WORKSPACE}"
        checkout([$class: 'GitSCM', branches: [[name: "${branch}"]], extensions: [], userRemoteConfigs: [[credentialsId: 'gitlab', url: 'http://gitlab.esuntown.com/ywyw/server/esuntown.git']]])
    }

    stage('mvn编译模块') {
        echo "构建公共模块：-------- ${env.WORKSPACE}/service-common & ${env.WORKSPACE}/ywyw-common --------"
        sh "mvn clean install -f ${env.WORKSPACE}/ywyw-common -DskipTest && mvn clean install -f ${env.WORKSPACE}/service-common -DskipTest"

        if (moduleName.contains("b2b-platform")) {
            sh "mvn clean install -f ${env.WORKSPACE}/b2b-platform/bff-web-base -DskipTest"
//            sh "mvn clean install -f ${env.WORKSPACE}/b2b-platform/bff-manager-base -DskipTest"

            sh "mvn clean install -f ${env.WORKSPACE}/${moduleName} -DskipTest"
        } else {
            sh "mvn clean install -f ${env.WORKSPACE}/${moduleName} -DskipTest"
        }

    }

    stage('开始构建镜像') {
        def moduleName = "${moduleName}" as String
        if (moduleName.contains("ywyw-")) {
            imageName = moduleName.substring(moduleName.indexOf("/") + 1, moduleName.length())
        }

        if (moduleName.contains("b2b-platform")) {
            imageName = moduleName.substring(moduleName.indexOf("/") + 1, moduleName.length())
        }

        echo "${env.WORKSPACE}/${moduleName}  ${imageName}"
        sh "cd ${env.WORKSPACE}/${moduleName} && docker build -t ${imageName}:${tag}-${env.BUILD_ID} ."
    }

    stage('推送镜像') {
        echo '推送镜像'
        sh 'pwd && ls -alh'
        // sh 'printenv'

        sh "docker login --username=易商通888 --password=Ywyw@888 ${aliRepository}"
        sh "docker tag ${imageName}:${tag}-${env.BUILD_ID} ${aliRepository}/${nameSpace}/${imageName}:${tag}-${env.BUILD_ID}"
        sh "docker push ${aliRepository}/${nameSpace}/${imageName}:${tag}-${env.BUILD_ID}"

        sh "docker rmi -f ${imageName}:${tag}-${env.BUILD_ID}"
        sh "docker rmi -f ${aliRepository}/${nameSpace}/${imageName}:${tag}-${env.BUILD_ID}"

    }

    stage('创建容器') {
        sh "/root/deploy/deploy.sh ${aliRepository}/${nameSpace}/${imageName} ${imageName} ${tag}-${env.BUILD_ID} ${project_env}"
    }

}
