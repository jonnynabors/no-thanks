# Getting Started

## Setting Up CI
Your project include a Jenkinsfile with a simple pipeline. It will run your tests and build your artifacts by default.
To setup your Jenkins instance to build this repository:

1) Create a new pipeline item

2) Set the jobs Build Trigger to poll SCM

3) Set the Pipeline Definition to `Pipeline script from SCM`

4) Set SCM to `git` and fill in your repository URL and credentials accordingly. 

For more information and examples, [click here](https://go.cloudbees.com/docs/cloudbees-documentation/use/automating-projects/jenkinsfile/
)
