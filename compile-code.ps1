echo "Compilation Started."

javac -d .\shippingsimulator\build\ .\shippingsimulator\src\main\atsea\*.java .\shippingsimulator\src\main\inport\*.java .\shippingsimulator\src\main\intro\*.java .\shippingsimulator\src\main\player\*.java .\shippingsimulator\src\main\utility\*.java

echo "Build Complete"

jar cfm Shipping-Simulator.jar MANIFEST.MF .\shippingsimulator\build\compilation\*.class

echo "JAR Creation complete."
