javac -d Terraria/build Terraria/src/*.java
javac -d Terraria/build Terraria/src/**/*.java
javac -d Terraria/build Terraria/src/**/**/*.java

jar -cvmf Terraria/scripts/manifest.txt TerrariaClone.jar Terraria/build/Terraria/*



sudo chmod +x TerrariaClone.jar