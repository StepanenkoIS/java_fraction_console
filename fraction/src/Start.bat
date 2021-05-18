javac -encoding utf-8 ru/fraction/calculator/Main.java
jar cfvm Main.jar ru/fraction/calculator/Manifest.txt ru/fraction/calculator/*.class
cd ru/fraction/calculator
erase *.class
cd..
cd..
cd..
java -cp Main.jar ru/fraction/calculator/Main


