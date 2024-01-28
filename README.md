# Maven code generation example

This example shows how to configure a [Maven](https://maven.apache.org/) project to consider code generation classes and generated code.
The usual procedure is:

1) Compiling the code generator itself
1) Running the code generator to, e.g., generate new java classes
1) Compile the whole project (including the previously generated classes)

The example can be used to, for example, use custom code generators and their functionality to generate code withing a CI pipeline (without the need to run individual steps manually).

[![CI](https://github.com/maxkratz/maven-code-gen-example/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/maxkratz/maven-code-gen-example/actions/workflows/ci.yml)


## Structure

| Name                                       | Type                   | Purpose                                                             |
| ------------------------------------------ | ---------------------- | ------------------------------------------------------------------- |
| [org.example.codegen](org.example.codegen) | Eclipse (java) project | Contains the sources of the custom code generator.                  |
| [ci.yml](.github/workflows/ci.yml)         | File                   | Example GitHub Actions configuration to build and push the project. |
| [pom.xml](org.example.codegen/pom.xml)     | File                   | Maven configuration file that contains the project's configuration. |


## How to build

- Generate code + build the project: \
`$ mvn clean package`
- Build + install the project to the local `.m2/` folder: \
`$ mvn clean install`
- Change the version of the plug-in to a new semver (e.g., before publishing a new release): \
`$ mvn versions:set -DnewVersion=0.0.2-SNAPSHOT`


## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for more details.
