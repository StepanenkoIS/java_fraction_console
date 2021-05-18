javac -encoding utf-8 ru/fraction/calculator/Main.java
jar cfvm Fraction.jar ru/fraction/calculator/Manifest.txt ru/fraction/calculator/*.class
cd ru/fraction/calculator
erase *.class
cd..
cd..
cd..
java -cp Fraction.jar ru/fraction/calculator/Main


