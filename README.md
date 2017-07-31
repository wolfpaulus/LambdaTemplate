This simple serverless computing application is intended to be used as a template project, a model, or starting point, for your next Java-based serverless cloud project. Here are the cornerstones:

- Java 8 is used as the implementation language of the serverless function(s)
- AWS Lamba is used as the Serverless runtime
- Gradle is used as the build automation system to compile, build, and deploy the serverless  function(s).
- JUnit 4 is used for unit-testing
- Jackson is used as the the JSON processor to serialize and deserialize objects
- Apache Log4J 1.2 is used as the remote logger on the serverless runtime system


**Task**

Using Java, to implement an AWS-Lambda functions and expose it through the AWS-API-Gateway. 
The task of the AWS Lambda function is simple, to determine if a provided number is a prime number or not. 
Here is an example of the input and output:

PrimeCheck: Find out if the number posted in a json-payload is a prime number, and return a response like this:

{"number":139} -> {"answer":"Yes, 139 is a prime number, divisible only by itself and 1","n":139,"d":1}

{"number":141} -> {"answer":"No, 141 is not a prime number. For instance, it's divisible by 3","n":141,"d":3}
