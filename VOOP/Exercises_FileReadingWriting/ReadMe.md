**Exercise 1**

This exercise is based on a Iris Flower Dataset, which is a small collection of data about iris flowers 🌸. 
It includes information on three types of iris flowers: Iris setosa, Iris versicolor, and Iris virginica. 
For each flower, the dataset contains four measurements: the length and width of the petals and sepals. 
In this regard, a comma-separated file called `flowerData.csv` is provided in the folder `csv`.
Each row in the file `flowerData.csv` represents `Id`, `sepal_length`, `sepal_width`, `petal_length`, `petal_width`, `species`
These fields can be seen as the
first entry in the `flowerData.csv` file. This exercise is divided into 2 subtasks, where you need to create a `flower` class and read a CSV file.


**Task 1a**: `public class Flower`


In this subtask, we have provided a class called `Flower.java` in the package `Exercise1`. An instance/object of the class should represent one entry in `flowerData.csv` file. Complete the implementation of the class.
(**Hint**: Remember to use the right access modifiers for variables, constructor and methods).
- Declare 6 variables for `Id(int)`, `sepalLength(double)` ,`sepalWidth(double)`,`petalLength(double)`, `petalWidth(double)`, `species(String)`.
- Create a 6 argument Constructor to initialize 6 variables.
- Create 6 Getter methods for retrieving the values of all the 6 variables. 
- A `toString()` method is already implemented but commented out. Uncomment this code and ensure that the called Getter methods in the `toString()` method corresponds to the ones you have created.

**Task 1b**: `public class ReadCSV` 

The purpose of this task is to read flower data from a file `FlowerData.csv` and store data in a Map (where `species` are `keys` and set of `Flower` objects are `values`).
We have provided a class `ReadCSV.java` in the `Exercise1` package.

**Provided Code**

- A private variable `file` of the type `File`, is already declared.
- A private variable `map` of the type `map<String, Set<Flower>>`, is already declared.
- A constructor `ReadCSV(String fileName)` that initializes `file` and `map` variables, is already created.
- A getter method is provided to retrieve `map`.

Complete the implementation of `ReadCSV.java` class as follows:

    (**Hint**)
    - Remember to skip the first line in the file - as it is an information line.
    - Use split() method to extract the relevant fields
    - Pay attention to numeric and double strings (`Integer.parseInt()/Double.parseDouble()`)

- Implement the `readFile()` method in the class.
    - Open a file and read each line in the file `flowerData.csv.` Remember that this file is comma separated “,” and relevant fields to be read are `Id`, `sepalLength`, `sepalWidth`, `petalLength`, `petalWidth`, `species`.
    - For each line, parse the relevant fields into their appropriate types and create a new instance of `Flower`.
    - While iterating through the data, use the relevant Getter method of the `Flower` object to get the `species` parameter and use this parameter to check if the `species` exists in the map object as a `key`. 
      - If the `species` does not exist in the map
        - create a new Set
        - add the new `Flower` object to the new Set
        - put the `species` and its corresponding Set of `Flower` objects in the map.
      - If the `species` already exists
        - simply add the newly created `Flower` object to the set of `Flower` objects belonging to that particular `species`.
   - Ensure that you enclose the input stream in a try – catch clause and close your input stream after use.
   - Make sure to catch the relevant exceptions that can be thrown.
- Test your implementations by executing the `main()` method of the `ReadCSV.java`.

**The output should look like the following:**

    {Iris-setosa=[ 33 	 	 5,20 	 	 4,10 	 	 1,50 	 	 0,10 	 	 Iris-setosa 
    ,  2 	 	 4,90 	 	 3,00 	 	 1,40 	 	 0,20 	 	 Iris-setosa
    ,  17 	 	 5,40 	 	 3,90 	 	 1,30 	 	 0,40 	 	 Iris-setosa 
    ,
    ,
    ,
    ,  129 	 	 6,40 	 	 2,80 	 	 5,60 	 	 2,10 	 	 Iris-virginica 
    ,  109 	 	 6,70 	 	 2,50 	 	 5,80 	 	 1,80 	 	 Iris-virginica
    ,  123 	 	 7,70 	 	 2,80 	 	 6,70 	 	 2,00 	 	 Iris-virginica
    ]}

**Exercise 2**

This exercise is based on a dataset which provides a rich source of information about stores and their locations, 
which can be leveraged for various analytical purposes in retail, marketing, urban planning, and other domains.
In this regard, a comma-separated file called `storeData.csv` is provided in the folder `csv`.
Each row in the file `storeData.csv` represents `Id`, `area`, `property`, `type`, `status`, `number`, `revenue`
These fields can be seen as the
first entry in the `storeData.csv` file. This exercise is divided into 2 subtasks, where you need to create a `store` class, read a CSV file and return a set of `store` objects which are of `property` **Rental**.

**Task 2a**: `public class Store`


In this subtask, we have provided a class called `Store.java` in the package `Exercise2`. An instance/object of the class should represent one entry in `storeData.csv` file.

(**Hint**: Remember to use the right access modifiers for variables, constructor and methods).

Complete the implementation of the class `Store.java`.

- Declare 7 variables for `Id(int)`, `area(double)`, `property(String)`, `type(String)`, `status(String)` ,`number(int)`,`revenue(long)`.
- Create a 7 argument Constructor to initialize 7 variables.
- Create 7 Getter methods for retrieving the values of all the 7 variables.
- A `toString()` method is already implemented but commented out. Uncomment this code and ensure that the called Getter methods in the `toString()` method corresponds to the ones you have created.

**Task 2b**: `public class ReadCSV`

The purpose of this task is to read `Store` data from a file `storeData.csv`, add `Store` objects in a `Set`, whose property is `Rental` and return the `Set`.
We have provided a class `ReadCSV.java` in the `Exercise2` package.

**Provided Code**

- A private variable `file` of the type `File`, is already declared.
- A private variable `set` of the type `Set<Store>`, is already declared.
- A constructor `ReadCSV(String fileName)` that initializes `file` and `set` variables, is already created.
- A getter method is provided to retrieve `set`.

Complete the implementation of `ReadCSV.java` class as follows:

    (**Hint**)
    - Remember to skip the first line in the file - as it is an information line.
    - Use split() method to extract the relevant fields
    - Pay attention to numeric, double, long strings (`Integer.parseInt()/Double.parseDouble()`)

- Implement the `readFile()` method in the class.
  - Open a file and read each line in the file `storeData.csv.` Remember that this file is comma separated “,” and relevant fields to be read are `Id`, `area`, `property`, `type`, `status`, `number`, `revenue`.
  - For each line, parse the relevant fields into their appropriate types and create a new instance of `Store`.
  - While iterating through the data, use the relevant Getter method of the `Store` object to get the `property` parameter and use this parameter to check if the `property` equals to`"Rental"`.
    - If the `property` equals to `"Rental"`
      - add the newly created `Store` object to the `set`.
  - Return the `set`.
  - Ensure that you enclose the input stream in a try – catch clause and close your input stream after use.
  - Make sure to catch the relevant exceptions that can be thrown.
- Test your implementations by executing the `main()` method of the `ReadCSV.java`.

**The output should look like the following:**

    [ 3 	 	 500,00 	 	 "Rental" 	 	 "Express" 	 	 "New" 	 	 2 	 	 8592000
    ,  5 	 	 220,00 	 	 "Rental" 	 	 "Express" 	 	 "Old" 	 	 2 	 	 3345500
    ,  9 	 	 1000,00 	 	 "Rental" 	 	 "Extra" 	 	 "New" 	 	 1 	 	 9744000
    ,
    ,
    ,
    ,  101 	 	 314,00 	 	 "Rental" 	 	 "Express" 	 	 "New" 	 	 2 	 	 5734500
    ,  102 	 	 290,00 	 	 "Rental" 	 	 "Express" 	 	 "New" 	 	 2 	 	 2415000
    ,  103 	 	 500,00 	 	 "Rental" 	 	 "Express" 	 	 "New" 	 	 2 	 	 5853000
    ]


**Exercise 3**

This exercise is based on file writing where you will write data stored in a `map<String, Flower>` to a text file `flowerInfo.txt`

**Provided Code**

- A class `Flower.java` is already provided with complete functionality.
- A class `WriteFlower.java` is provided with limited functionality.

Complete the implementation of `WriteFlower.java` class as follows:

- Study the code that is provided to you in `WriteFlower.java` (variables, constructor and `main()` method)
- Implement the `writeFile(Map<String,Flower> m)` method in the class.
  - Open a file `flowerInfo.txt` using output stream.
  - Iterate over the map `Map<String, Flower>`
  - While iterating through the map, write `key` and `value` in the text file `flowerInfo.txt`
- Ensure that you enclose the output stream in a try – catch clause and close your output stream after use.
- Make sure to catch the relevant exceptions that can be thrown.
- Test your implementations by executing `WriteFlower.java`.

**The output should look like the following:**

    Iris-setosa:  33 	 	 5,00 	 	 20,00 	 	 4,00 	 	 10,00 	 	 Iris-setosa
    Iris-versicolor:  66 	 	 6,70 	 	 3,10 	 	 4,40 	 	 1,40 	 	 Iris-versicolor
    Iris-virginica:  129 	 	 6,00 	 	 40,00 	 	 2,00 	 	 80,00 	 	 Iris-virginica 

**Exercise 4**

This exercise is based on file writing where you will write total revenue of all the `Store` objects stored in a `Set<Store>` to a text file `storeInfo.txt`

**Provided Code**

- A class `Store.java` is already provided with complete functionality.
- A class `WriteStore.java` is provided with limited functionality.

Complete the implementation of `WriteStore.java` class as follows:

- Study the code that is provided to you in `WriteStore.java` (variables, constructor and `main()` method)
- Implement the `writeFile(Set<Store> set)` method in the class.
  - Iterate over the set `Set<Store>`.
    - for each `Store` object, retrieve the `revenue` using getter method of `Store` class.
    - compute the sum of revenue for all `Store` objects.
  - Open a file `storeInfo.txt` using output stream, and write the value of total `revenue` computed above.
- Ensure that you enclose the output stream in a try – catch clause and close your output stream after use.
- Make sure to catch the relevant exceptions that can be thrown.
- Test your implementations by executing `WriteStore.java`.

**The output should look like the following:**

    Total revenue of all stores= 3.6081E7