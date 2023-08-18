sha=`git rev-parse HEAD`
docker build -t recommendation-api:$sha .
cloudlift upload_to_ecr --name recommendation-api --local_tag $sha
cloudlift deploy_service -e hackathon --name recommendation-api --version $sha