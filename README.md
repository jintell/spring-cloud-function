# Getting Started

### Spring Cloud Function implementation and and deployment to AWS LAMBDA

Spring has created a fantastic serverless or cloud function implementation that is cloud provider agnostic 
for serverless computing.

You can utilize the [spring.io](https://spring.io/serverless) or you can the sample 
[github page](https://github.com/spring-cloud/spring-cloud-function/tree/main) to kick off your
serverless (FaaS) journey immediately from here.

### Test the Project Locally

1. Build the project. Don't forget to uncomment the [spring-cloud-starter-function-webflux]() dependency

`./gradlew clean build -x test`

2. Execute the artifact

`java -jar build/libs/functions-1-SNAPSHOT.jar`

3. Test the local deployment

`curl http://localhost:8080/reverse -d 'Hello World'`

Result

`"dlroW olleH"{`


### Test the Project on AWS  Lambda

1. Build the project. Don't forget to comment out the [spring-cloud-starter-function-webflux]() dependency

`./gradlew clean build -x test`

2. Deploy to AWS console. you can copy the built artifact or you can deploy it using the serverless tool. This is out 
of scope of the demo. You can learn more [here](https://www.serverless.com/framework/docs/getting-started)

The artifact to deploy is [functions-1-SNAPSHOT-aws.jar]()

### Note
From experience playing around this, It is the specific cloud provider adapter [spring-cloud-function-adapter-aws]() 
that you need to add to your dependencies, and comment out the spring boot web or webflux starter dependency 
[spring-cloud-starter-function-webflux](). 
It will still work on your preferred cloud function provider, only it will affect the your final shaded jar file size.

You may want to see the build.gradle file for this project.

### Additional Hints

If you are going to run a test on AWS Lambda function console, Please set the handler to:`
org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest` This is the purpose of your adapter that 
was added to your dependencies. 

Also, if you have more than one function in your configuration, add a new `Key` 
`spring_cloud_function_definition` in the environment variable under `Configuration` in the console and add under the 
`Value` your function name for example `reverse`. You can create another function and do the same.

I will suggest your artifact is uploaded to S3 and create your functions from the bucket, instead of uploading for 
each function you want to create. I will also recommend using the serverless tool, which will let you utilize the 
AWS cloud formation that help you to manage your resources



