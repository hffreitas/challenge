# Challenge

## Comparator package
In this package we can find the comparators that are available to use.
## Converter
In this package we have two different converters (csv and ascii files). Both converters implement the interface EmployeeConverter which has the convertTo method that receives one line and parses it to Employee object.
## Processor
Processor is the responsible for deciding wich converter will be used according the first line of input file.
## How to use
`java -jar challenge-1.0.0.jar inputFile outputFile [comparatorField]`

#### inputFile
File with list of employees to be processed. The first line must be 1 or 2  if it is an ascii file or a csv file (resp.)
#### outputFile
File to use as output
#### comparatorField
comparatorField should be FirstName, LastName or StartDate that will be the field used to order the output file.
This field is optional. By default it will order by FirstName.

### Example
`java -jar challenge-1.0.0.jar test.csv final.txt LastName`