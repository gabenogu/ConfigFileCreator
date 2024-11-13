# ConfigFileCreator

## Description
This is a Config File Creator for YCSB benchmarking

User can enter command lines such as -rc, -oc, etc. to configure a custom file
    -if the user does not give any commands or values, it will default to a generic YSCB workload configuration

It will ask the user to enter in a file path name 
    -Important to note that user must enter ENTIRE path
    -Ex. "C:\\Users\\Your\\Path.txt
    -must use \\ for java logic 
After correctly identifying a location a file will be created 

Users must take note of the locaiton if they are to use it for a YCSB benchmark

## Installation
1. Download Intellij or similar java IDE

2. Fork the repository or clone it directly

    git clone https://github.com/yourusername/yourrepository.git

## Install args4j
1. go to https://repo1.maven.org/maven2/args4j/args4j/2.33/
2. download 'args4j-2.33.jar'
3. 
## Set args4j as a dependency
1. In your java project go to File -> Project Structure -> Modules -> Dependencies
2. Click the + button, then click Jars and directories
3. Navigate to your download location of args4j-2.33.jar, click on it then click ok
4. click apply

Once this is all done it should run as intended.
If you are having issues running the CLI version in the terminal this may help you:

## Configure main file
1. on the top of your Intellij IDE, under Current File, select 'Edit Configurations'
2. click 'Add new run configuration'
3. click 'Application'
4. in the greyed out seciton of 'Main Class', select the icon to the right then select Main
5. Click apply and ok

## running the CLI through Intellij
Once you have the main class configured, you can run the cli through Intellij
1. You should see a new icon where it previously said 'Current File'
2. click that tab and again click 'Edit Configurations'
3. There should be a field for 'Program Arguments', This is where the CLI commands go

If you want to test it try this in the program arguments field
-rc 10000 -oc 10000 -rp 0.3 -up 0.7
If done correctly, it will output these values to the console as well

Make sure when you put the fields in that you only have the "-command $value"
If you put a comma in between each command and value it will give an error
