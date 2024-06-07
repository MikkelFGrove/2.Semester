**Lecture 2: Exercise 2(Danish Island)** (From ReExam)

Unzip DanishIslandExercise.zip. You will find:

1. Islands komma.txt 
2. Islands punktum.txt

The files contain various information about Danish inhabited islands. The information in the files is the same, except for whether the decimal point is a comma or a full stop. Each line represents one island with the following data (separated by spaces): 

**Navn Omkreds Areal Addresser Adr/km2 af datatyperne (String, double, double, int, int).**

• A java package danishisland with the classes:
* DanishIsland: objects of this class represent one island. Study the code, it is fully implemented.
* DanishIslandFileReader: Code skeleton for reading the island text file. Study the code and implement what is missing

  ▪ Load the file one line at a time. Split the line on the space character.

  ▪ Convert the individual values to the types to be used in DanishIsland.

  ▪ Create an object for each line and add it to the list.

  ▪ Be careful to catch exceptions and close the scanner and file.

  ▪ In the main() method you can choose whether to use comma or period as decimal character for double values