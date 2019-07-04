javac -d Terraria/build Terraria/src/*.java
javac -d Terraria/build Terraria/src/**/*.java
javac -d Terraria/build Terraria/src/**/**/*.java

java -cp Terraria/build/ Terraria.src.Game

# rm -f Terraria/src/*.class
# rm -f Terraria/src/**/*.class
# rm -f Terraria/src/**/**/*.class