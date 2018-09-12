if [ ${TRAVIS_PULL_REQUEST} = 'false' ] && [[ $TRAVIS_BRANCH = 'master'  ||  ${TRAVIS_BRANCH} = 'develop' ]]; then
    ...
elif [ ${TRAVIS_PULL_REQUEST} != 'false' ]; then
      echo 'Build and analyze pull request'
      mvn -B clean verify sonar:sonar \
      -Dsonar.host.url=${SONAR_URL} \
      -Dsonar.projectKey=${SONAR_PROJECT} \
      -Dsonar.organization=${SONAR_ORGANIZATION} \
      -Dsonar.login=${SONAR_LOGIN} \
      -Dsonar.github.oauth=${SONAR_GITHUB_OAUTH} \
      -Dsonar.pullrequest.github.repository=${TRAVIS_REPO_SLUG}  \
      -Dsonar.pullrequest.provider=GitHub  \
      -Dsonar.pullrequest.branch=${TRAVIS_BRANCH}  \
      -Dsonar.pullrequest.key=${TRAVIS_PULL_REQUEST};
fi