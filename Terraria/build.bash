javac -d Terraria/build Terraria/src/*.java
javac -d Terraria/build Terraria/src/**/*.java
javac -d Terraria/build Terraria/src/**/**/*.java

jar -cvmf  Terraria/scripts/manifest.txt TerrariaClone.jar Terraria/build/Terraria/*

echo "Generated jar TerrariaClone.jar"

sudo chmod +x TerrariaClone.jar
